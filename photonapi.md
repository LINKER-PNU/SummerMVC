# PhotonAPI

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/create" %}
{% api-method-summary %}
pathCreate
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="GameId" type="string" required=true %}
Name of room to create.
{% endapi-method-parameter %}

{% api-method-parameter name="UserId" type="string" required=true %}
User who created room.
{% endapi-method-parameter %}

{% api-method-parameter name="Nickname" type="string" required=true %}
The user's nickname.
{% endapi-method-parameter %}

{% api-method-parameter name="Type" type="string" required=true %}
If the room is created first time, put it "Create" but recreated, put it "Load".
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=201 %}
{% api-method-response-example-description %}
Room successfully created.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 0    }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=400 %}
{% api-method-response-example-description %}
Room name is already in database, means duplicated. The room is not inserted.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 1    }
```
{% endapi-method-response-example %}

{% api-method-response-example httpCode=401 %}
{% api-method-response-example-description %}
Room name is over the max length.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 2    }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/join" %}
{% api-method-summary %}
pathJoin
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="GameId" type="string" required=true %}
Name of room to join.
{% endapi-method-parameter %}

{% api-method-parameter name="UserId" type="string" required=true %}
User who join the room.
{% endapi-method-parameter %}

{% api-method-parameter name="Nickname" type="string" required=true %}
The user's nickname.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=201 %}
{% api-method-response-example-description %}
Joining room successful.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 0    }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/leave" %}
{% api-method-summary %}
pathLeave
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="GameId" type="string" required=true %}
Name of room to leave.
{% endapi-method-parameter %}

{% api-method-parameter name="UserId" type="string" required=true %}
User who leave the room.
{% endapi-method-parameter %}

{% api-method-parameter name="Nickname" type="string" required=true %}
The user's nickname.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=201 %}
{% api-method-response-example-description %}
Leaving room successful.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 0    }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/close" %}
{% api-method-summary %}
pathClose
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="GameId" type="string" required=true %}
Name of room to close.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}
Closing room successful.
{% endapi-method-response-example-description %}

```text
{    "State": "", "ResultCode": 0    }
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/auth\_room" %}
{% api-method-summary %}
authRoom
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomCode" type="string" required=true %}
Invite code of the room to get name.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
linker_test
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/room\_code" %}
{% api-method-summary %}
getRoomCode
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Name of room to get invite code.
{% endapi-method-parameter %}
{% endapi-method-body-parameters %}
{% endapi-method-request %}

{% api-method-response %}
{% api-method-response-example httpCode=200 %}
{% api-method-response-example-description %}

{% endapi-method-response-example-description %}

```text
gkdnl
```
{% endapi-method-response-example %}
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

{% api-method method="post" host="http://eggcation.linker.ac:8080" path="/room\_exist" %}
{% api-method-summary %}
checkRoomExist
{% endapi-method-summary %}

{% api-method-description %}

{% endapi-method-description %}

{% api-method-spec %}
{% api-method-request %}
{% api-method-body-parameters %}
{% api-method-parameter name="roomName" type="string" required=true %}
Name of room to check.
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
{% endapi-method-response %}
{% endapi-method-spec %}
{% endapi-method %}

