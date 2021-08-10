# HomeAPI

{% api-method method="post" host="https://api.cakes.com" path="/login" %}
{% api-method-summary %}
login
{% endapi-method-summary %}

{% api-method-description %}
This endpoint allows you to get free cakes.
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

```
{"resultUser" : }
```

{% endapi-method-response-example %}

{% api-method-response-example httpCode=404 %}
{% api-method-response-example-description %}
Could not find a cake matching this query.
{% endapi-method-response-example-description %}

```
{    "message": "Ain't no cake like that."}
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}
