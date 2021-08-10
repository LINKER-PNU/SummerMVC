# BoardAPI

{% api-method method="post" host="https://api.cakes.com" path="/board/list" %}
{% api-method-summary %}
getBoards
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Write room name, where boards belong.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```
[{
    boardAssignment: true
    boardDeadline: "2000-01-01 00:00:00"
    boardEditDt: "2000-01-01 00:00:00"
    boardId: 1
    boardNotice: false
    boardTitle: "title"
    boardVisible: false
    boardWriteDt: "2000-01-01 00:00:00"
    boardWriter: "name"
    boardWriterId: "id"
},
{
    boardAssignment: true
    boardDeadline: "2000-01-01 00:00:00"
    boardEditDt: "2000-01-01 00:00:00"
    boardId: 3
    boardNotice: false
    boardTitle: "title3"
    boardVisible: false
    boardWriteDt: "2000-01-01 00:00:00"
    boardWriter: "name2"
    boardWriterId: "id2"
}]
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="" path="/board/content" %}
{% api-method-summary %}
getBoardContent
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="boardId" type="integer" required=true %}
Write id of the board you clicked.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Response content as string, not json format.
{% endapi-method-response-example-description %}

```
content
```

{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}
