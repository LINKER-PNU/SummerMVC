# TimerAPI

{% api-method method="post" host="https://api.cakes.com" path="/timer/add" %}
{% api-method-summary %}
addTimer
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="timerUser" type="string" required=true %}
ID of user who use this timer.
{% endapi-method-parameter %}

{% api-method-parameter name="timerRoom" type="string" required=true %}
Room name where this timer belongs to.
{% endapi-method-parameter %}

{% api-method-parameter name="timerSubject" type="string" required=true %}
Subject name of this timer.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Cake successfully retrieved.
{% endapi-method-response-example-description %}

```
{ "result" : true }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="" path="/timer/list" %}
{% api-method-summary %}
getTimers
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="timerUser" type="string" required=true %}
ID of user.
{% endapi-method-parameter %}

{% api-method-parameter name="timerRoom" type="string" required=true %}
Room where this user belongs to.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```

```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

