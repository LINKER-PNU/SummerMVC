# TimerAPI

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/timer/add" %}
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
Timer insert complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/timer/list" %}
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
Response timer information complete successfully.
{% endapi-method-response-example-description %}

```text
[
  { "timerId": 2, "timerSubject": "subj2", "timerStudyTime": 15 },
  { "timerId": 4, "timerSubject": "timerSubject3", "timerStudyTime": 0 }
]
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/timer/stop" %}
{% api-method-summary %}
stopTimer
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="timerId" type="integer" required=true %}
ID of the timer to stop.
{% endapi-method-parameter %}

{% api-method-parameter name="timerStudyTime" type="integer" required=true %}
Study time\(second\) at this moment.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Timer stopped successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/timer/edit" %}
{% api-method-summary %}
editTimer
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="timerId" type="integer" required=true %}
ID of the timer to edit its subject name.
{% endapi-method-parameter %}

{% api-method-parameter name="timerSubject" type="string" required=true %}
Subject name to edit.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Timer edit complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/timer/remove" %}
{% api-method-summary %}
removeTimer
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="timerId" type="integer" required=true %}
ID of the timer to remove.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Timer remove complete successfully.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 200 }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=500 %}
{% api-method-response-example-description %}
Something is wrong at requestion on DB.
{% endapi-method-response-example-description %}

```text
{ "resultCode" : 500 }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

