# HomeAPI

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/login" %}
{% api-method-summary %}
login
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="authToken" type="string" required=true %}
Token from GameSparks
{% endapi-method-parameter %}

{% api-method-parameter name="displayName" type="string" required=true %}
User's nickname
{% endapi-method-parameter %}

{% api-method-parameter name="userId" type="string" required=true %}
Uid from GameSparks
{% endapi-method-parameter %}

{% api-method-parameter name="newPlayer" type="boolean" required=true %}
New player or not
{% endapi-method-parameter %}

{% api-method-parameter name="skinRole" type="string" required=false %}
Set role. It must be **char** type 'S' or 'T' which means 'Student' and 'Teacher'. You don't have to write it at sign in.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Sign up/in complete successfully.
{% endapi-method-response-example-description %}

```text
{ "result" : 200 }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```
{ "result" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/user" %}
{% api-method-summary %}
getUserInfo
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="userId" type="string" required=true %}
Id of user.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Response existing user information successfully.
{% endapi-method-response-example-description %}

```text
{
  "user_skin_role": "S",
  "user_room": [
    { "room_present": 0, "room_max": 3, "room_name": "linker_test" },
    { "room_present": 0, "room_max": 1, "room_name": "새로운방" }
  ],
  "user_name": "2TEST",
  "result_room": "success",
  "user_skin_color": "FFFFFFFF",
  "user_skin_cloth": ""
  "result": 200
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}
Rest of all is fine, but there is no user client requests on DB.
{% endapi-method-response-example-description %}

```
{
    "user_room": []
    "result": 400
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion at DB.
{% endapi-method-response-example-description %}

```
{ "result" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/skin" %}
{% api-method-summary %}
updateSkinColor
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="userId" type="string" required=true %}
Id of the user to change color.
{% endapi-method-parameter %}

{% api-method-parameter name="skinColor" type="string" required=true %}
Color you set.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Update user's skin color successfully.
{% endapi-method-response-example-description %}

```text
{ "result" : 200 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/cloth" %}
{% api-method-summary %}
updateSkinCloth
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="userId" type="string" required=true %}
Id of the user to change cloth
{% endapi-method-parameter %}

{% api-method-parameter name="skinCloth" type="string" required=true %}
Cloth you set.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```
{ "result" : true }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

