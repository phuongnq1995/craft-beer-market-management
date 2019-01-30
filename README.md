Nguyen-Quang-Phuong-Assignment  <br />

Link heroku : http://craft-beer-market-management.herokuapp.com  <br />

User(Admin) web interface  <br />
username:admin  <br />
password:admin  <br />

Client(mobile app) web api to authorization.  <br />
clientId:client  <br />
clientSecret:secret  <br />

GUIDELINE API (Use curl or postman for testing)  <br />

-Client app want to use Api like anonymously without logging have to call to get token.  <br />
Use client token set to header "Authorization" tag in per request to backend.  <br />
Client can call to backend get new token every time.  <br />
Use client token get list of beers available with pagination(default page = 0, size = 10).  <br />
When client register a customer success then backend auto-login return a customer token.  <br />

-Customer want to use Api have to login to get token.  <br />
Use customer token set to header "Authorization" tag in per request.  <br />
Customer can consume a beer by send a "beerId" to backend.The "beerId" appear on list of beers available result).  <br />
Customer can call to backend get new token every time.  <br />
Use customer token get list of beer available(pagination) 
include all the ones they’ve consumed and all beers that are available that they haven't tried yet.  <br />
When get list of beers available then the result depent on token owner.  <br />

-Token expire time valid in 1 hour.Whenever client or customer new a token, old token will destroy.  <br />

=====================Get client token=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/login/client  <br />
Method: POST  <br />
Content-Type: application/json  <br />
```json
{"clientId":"client","clientSecret":"secret"}
```
=====================Body response=====================  <br />
```json
{
    "token": "xxxxxClient-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}
```

=====================Register customer=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/register/customer  <br />
Method: POST  <br />
Authorization: xxxxxClient-tokenxxxxx  <br />
Content-Type: application/json  <br />
```json
{"fullname":"Customer","username":"customer","password":"customer","passwordConfirm":"customer"}
````
=====================Body response=====================  <br />
```json
{
    "token": "xxxxxCustomer-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}
```

=====================Get customer token=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/login/customer  <br />
Method: POST  <br />
Authorization: xxxxxClient-tokenxxxxx  <br />
Content-Type: application/json  <br />
```json
{"username":"customer","password":"customer"}
```
=====================Body response=====================  <br />
```json
{
    "token": "xxxxxCustomer-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}
```

=====================Customer consume a beer=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/customer/consume  <br />
Method: POST  <br />
Authorization: xxxxxCustomer-tokenxxxxx  <br />
Content-Type: application/json  <br />
```json
{"beerId":xxBeerIdxx}
```
=====================Body response=====================  <br />
```json
{xxxxHistory-informationxxxx}
```

=====================Get list of beers available=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/beer?page=0&size=10  <br />
Method: GET  <br />
Authorization: xxxxxClient-token or Customer-tokenxxxxx  <br />

=====================Client Body response=====================  <br />
```json
{
    "beers": {
        "content": [
            {xxxBeer-informationxxx},{xxxxxBeer-informationxxxxx}
        ],
        "last": true/false,
        "totalPages": number,
        "totalElements": number,
        "sort": null,
        "first": true/false,
        "numberOfElements": number,
        "size": number,
        "number": number
    }
}
```
=====================Customer Body response=====================  <br />
```json
{
    "beers": {
        "content": [
            {xxxBeer-informationxxx},{xxxxxBeer-informationxxxxx}
        ],
        "last": true/false,
        "totalPages": number,
        "totalElements": number,
        "sort": null,
        "first": true/false,
        "numberOfElements": number,
        "size": number,
        "number": number
    }
    "history": [{xxxHistory-informationxxx}, {xxxHistory-informationxxx}],
    "haveNotTried": [{xxxBeer-informationxxx},{xxxBeer-informationxxx}]
}
```
