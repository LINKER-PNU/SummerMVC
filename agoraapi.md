# AgoraAPI

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/get\_token" %}
{% api-method-summary %}
getToken
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Room name you want to get token from.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Cake successfully retrieved.
{% endapi-method-response-example-description %}

```text
{
    "agoraToken" : "006ee7508ef6b2042e7b6dd141a6a11895aIADa8B09gdmuktCBune0hxyI17VZvcaq91eDeuKTEmRc6DuyHY0AAAAAIgCWQ0xQJzYyYQQAAQAL5TBhAgAL5TBhAwAL5TBhBAAL5TBh",
    "roomId" : "15"
}
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```
-1
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/check\_class\_exist" %}
{% api-method-summary %}
checkClassExist
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Room name you want to check class exist or not.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
If class exists.
{% endapi-method-response-example-description %}

```text
true
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=202 %}
{% api-method-response-example-description %}
If class not exists.
{% endapi-method-response-example-description %}

```text
false
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/insert\_class\_master" %}
{% api-method-summary %}
insertClassMaster
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="classMaster" type="string" required=true %}
Class master uid.
{% endapi-method-parameter %}

{% api-method-parameter name="roomName" type="string" required=true %}
Room name you want to insert master uid.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=201 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
true
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
false
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/delete\_class\_master" %}
{% api-method-summary %}
deleteClassMaster
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Room name you want to delete class master.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
true
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
false
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/is\_class\_master" %}
{% api-method-summary %}
isClassMaster
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="classMaster" type="string" required=true %}
Uid you want to check is master or not.
{% endapi-method-parameter %}

{% api-method-parameter name="roomName" type="string" required=true %}
Room name you want to check master.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
true
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=202 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
false
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

