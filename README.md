Nguyen-Quang-Phuong-Assignment

Link heroku : http://craft-beer-market-management.herokuapp.com

User(Admin) web interface
username:admin
password:admin

Client(mobile app) web api to authorization.
clientId:client
clientSecret:secret

GUIDELINE API(Use curl or postman for testing)

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

{"clientId":"client","clientSecret":"secret"}  <br />

=====================Body response=====================  <br />
{
    "token": "xxxxxClient-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}

=====================Register customer=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/register/customer  <br />
Method: POST  <br />
Authorization: xxxxxClient-tokenxxxxx  <br />
Content-Type: application/json  <br />

{"fullname":"Customer","username":"customer","password":"customer","passwordConfirm":"customer"}  <br />

=====================Body response=====================  <br />
{
    "token": "xxxxxCustomer-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}

=====================Get customer token=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/login/customer  <br />
Method: POST  <br />
Authorization: xxxxxClient-tokenxxxxx  <br />
Content-Type: application/json  <br />

{"username":"customer","password":"customer"}  <br />

=====================Body response=====================  <br />
{
    "token": "xxxxxCustomer-tokenxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}

=====================Customer consume a beer=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/customer/consume  <br />
Method: POST  <br />
Authorization: xxxxxCustomer-tokenxxxxx  <br />
Content-Type: application/json  <br />

{"beerId":xxBeerIdxx}  <br />

=====================Body response=====================  <br />
{xxxxHistory-informationxxxx}

=====================Get list of beers available=====================  <br />
URL: craft-beer-market-management.herokuapp.com/api/beer?page=0&size=10  <br />
Method: GET  <br />
Authorization: xxxxxClient-token or Customer-tokenxxxxx  <br />

=====================Client Body response=====================  <br />
{  <br />
    "beers": {  <br />
        "content": [  <br />
            {xxxBeer-informationxxx},{xxxxxBeer-informationxxxxx}  <br />
        ],  <br />
        "last": true/false,  <br />
        "totalPages": number,  <br />
        "totalElements": number,  <br />
        "sort": null,  <br />
        "first": true/false,  <br />
        "numberOfElements": number,  <br />
        "size": number,  <br />
        "number": number  <br />
    }  <br />
}  <br />

=====================Customer Body response=====================  <br />
{  <br />
    "beers": {  <br />
        "content": [  <br />
            {xxxBeer-informationxxx},{xxxxxBeer-informationxxxxx}  <br />
        ],  <br />
        "last": true/false,  <br />
        "totalPages": number,  <br />
        "totalElements": number,  <br />
        "sort": null,  <br />
        "first": true/false,  <br />
        "numberOfElements": number,  <br />
        "size": number,  <br />
        "number": number  <br />
    }  <br />
    "history": [{xxxBeer-informationxxx}, {xxxBeer-informationxxx}],  <br />
    "haveNotTried": [{xxxBeer-informationxxx},{xxxBeer-informationxxx}]  <br />
}  <br />
