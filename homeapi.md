# HomeAPI

{% api-method method="post" host="https://api.cakes.com" path="/login" %}
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
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Cake successfully retrieved.
{% endapi-method-response-example-description %}

```text
{ "result" : true }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="" path="/user" %}
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

{% endapi-method-response-example-description %}

```
{
  "result_user": "success",
  "user_skin_role": "S",
  "user_room": [
    { "room_present": 0, "room_max": 3, "room_name": "linker_test" },
    { "room_present": 0, "room_max": 1, "room_name": "새로운방" }
  ],
  "user_id": "61029561de098611321319d7",
  "result_room": "success",
  "user_skin_color": 0
}
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="" path="/skin" %}
{% api-method-summary %}
updateSkin
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="userId" type="integer" required=true %}
Id of the user to change skin.
{% endapi-method-parameter %}

{% api-method-parameter name="skinColor" type="integer" required=true %}
Color you set.
{% endapi-method-parameter %}

{% api-method-parameter name="skinRole" type="string" required=true %}
Set role. It must be **char** type 'S' or 'T' which means 'Student' and 'Teacher'.
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

