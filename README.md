Nguyen-Quang-Phuong-Assignment

Link heroku : http://craft-beer-market-management.herokuapp.com

User(Admin) web interface
username:admin
password:admin

Client(mobile app) web api to authorization.
clientId:client
clientSecret:secret

GUIDELINE API(Use curl or postman for testing)

-Client app want to use Api like anonymously without logging have to call to get token.
Using client's token set to header Authorization in per request to backend.
Client can call to backend get new token everytime.
Client app can get beers with pagination(default page = 0, size = 10).
When client register a customer success then backend auto-login return a customer's token.
-Customer want to use Api have to login to get token.
Using customer's token set to header Authorization in per request.

-Token's expire time 1 hour.

=======Code get client's token=======
POST /api/login/client
Host: craft-beer-market-management.herokuapp.com
Content-Type: application/json

{"clientId":"client","clientSecret":"secret"}

=======Body response=======
{
    "token": "xxxxxxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}

=======Code get list of beers available=======
GET /api/beer?page=0&size=10
Host: craft-beer-market-management.herokuapp.com
Content-Type: application/json
Authorization: xxxxxxxxxx

=======Body response=======
{
    "beers": {
        "content": [
            {xxxxxxxxxx},{xxxxxxxxxx}
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

=======Code register customer(auto login)=======
POST /api/register/customer
Host: craft-beer-market-management.herokuapp.com
Authorization: xxxxxxxxxx
Content-Type: application/json

{"fullname":"Customer","username":"customer","password":"customer","passwordConfirm":"customer"}

=======Body response=======
{
    "token": "xxxxxxxxxx",
    "expireTime": "dd/MM/yyyy hh:mm:ss"
}


