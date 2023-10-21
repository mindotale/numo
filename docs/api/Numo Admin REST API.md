# Numo! Admin REST API

## Introduction

**API Root:** https://admin.numo.com/api/v1/

## Table of Contents

- [Numo! Admin REST API](#numo-admin-rest-api)
  - [Introduction](#introduction)
  - [Table of Contents](#table-of-contents)
  - [Groups](#groups)
    - [Group](#group)
    - [Get a Group](#get-a-group)
    - [Get Groups](#get-groups)
    - [Create a Group](#create-a-group)
    - [Update a Group](#update-a-group)
    - [Delete a Group](#delete-a-group)
    - [Get a Group Child](#get-a-group-child)
    - [Get Group Children](#get-group-children)
  - [Parents](#parents)
    - [Parent](#parent)
    - [Get a Parent](#get-a-parent)
    - [Get Parents](#get-parents)
    - [Get Parent Children](#get-parent-children)
    - [Get Parent Likes](#get-parent-likes)
    - [Get Parent Dislikes](#get-parent-dislikes)
  - [Children](#children)
    - [Child](#child)
    - [Get a Child](#get-a-child)
    - [Get Children](#get-children)
  - [Messages](#messages)
    - [Message](#message)
    - [Get a Message](#get-a-message)
    - [Get Messages](#get-messages)
    - [Create a Message](#create-a-message)
    - [Update a Message](#update-a-message)
    - [Delete a Message](#delete-a-message)
    - [Get Message Groups](#get-message-groups)

## Groups

### Group
```json
{
    "id": 123,
    "name": "string",
    "count":  0,
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

### Get a Group

`GET` /groups/{id}

**Response**
```json
{
    "id": 123,
    "name": "string",
    "count":  0,
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

### Get Groups

`GET` /groups

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "name": "string",
        "count": 0,
        "minAge": 0,
        "maxAge": 0,
        "minChildCount": 0,
        "maxChildCount": 0,
        "locations": [
          "string"
        ],
        "sources": [
          "string"
        ]
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

### Create a Group

`POST` /groups

**Request**
```json
{
    "name": "string",
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

**Response**
```json
{
    "id": 123,
    "name": "string",
    "count":  0,
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

### Update a Group

`PUT` /groups/{id}

**Request**
```json
{
    "name": "string",
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

**Response**
```json
{
    "id": 123,
    "name": "string",
    "count":  0,
    "minAge": 0,
    "maxAge": 0,
    "minChildCount": 0,
    "maxChildCount": 0,
    "locations": [
        "string"
    ],
    "sources": [
        "string"
    ]
}
```

### Delete a Group

`DELETE` /groups/{id}

### Get a Group Child

`GET` /groups/{group_id}/children/{child_id}

**Response**
```json
{
    "id": 123,
    "parentId": 789,
    "name": "string",
    "birthDate": "2002-12-31"
}
```

### Get Group Children

`GET` /groups/{id}/children

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "parentId": 789,
        "name": "string",
        "birthDate": "2002-12-31"
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

## Parents

### Parent
```json
{
    "id": 123,
    "name": "string",
    "location": "string",
    "childСount": 0,
    "source": "string",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "0000-00-00T00:00:00.000Z",
    "lastActiveAt": "0000-00-00T00:00:00.000Z"
}
```

### Get a Parent

`GET` /parents/{id}

**Response**
```json
{
    "id": 123,
    "name": "string",
    "location": "string",
    "childСount": 0,
    "source": "string",
    "likeCount": 0,
    "dislikeCount": 0,
    "registeredAt": "0000-00-00T00:00:00.000Z",
    "lastActiveAt": "0000-00-00T00:00:00.000Z"
}
```

### Get Parents

`GET` /parents

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "name": "string",
        "location": "string",
        "childСount": 0,
        "source": "string",
        "likeCount": 0,
        "dislikeCount": 0,
        "registeredAt": "0000-00-00T00:00:00.000Z",
        "lastActiveAt": "0000-00-00T00:00:00.000Z"
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

### Get Parent Children

`GET` /parents/{id}/children

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "parentId": 789,
        "name": "string",
        "birthDate": "2002-12-31"
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

### Get Parent Likes

`GET` /parents/{id}/likes

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "messageId": ""
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

### Get Parent Dislikes

`GET` /parents/{id}/dislikes

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "messageId": ""
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```


## Children

### Child
```json
{
    "id": 123,
    "parentId": 789,
    "name": "string",
    "birthDate": "2002-12-31"
}
```

### Get a Child

`GET` /children/{id}

**Response**
```json
{
    "id": 123,
    "parentId": 789,
    "name": "string",
    "birthDate": "2002-12-31"
}
```

### Get Children

`GET` /children

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "parentId": 789,
        "name": "string",
        "birthDate": "2002-12-31"
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

## Messages 

### Message
```json
{
    "id": 123,
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Get a Message

`GET` /messages/{id}

**Response**
```json
{
    "id": 123,
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Get Messages

`GET` /messages

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "content": "string",
        "name": "string",
        "startDate": "0000-00-00T00:00:00.000Z",
        "repeatDays": 0
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```

### Create a Message

`POST` /messages

**Request**
```json
{
    "groupIds": [
        "00000000-0000-0000-0000-000000000000"
    ],
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

**Response**
```json
{
    "id": 123,
    "groupIds": [
        "00000000-0000-0000-0000-000000000000"
    ],
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Update a Message

`PUT` /messages/{id}

**Request**
```json
{
    "groupIds": [
        "00000000-0000-0000-0000-000000000000"
    ],
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

**Response**
```json
{
    "id": 123,
    "groupIds": [
        "00000000-0000-0000-0000-000000000000"
    ],
    "name": "string",
    "content": "string",
    "startDate": "0000-00-00T00:00:00.000Z",
    "repeatDays": 0
}
```

### Delete a Message

`DELETE` /messages/{id}

### Get Message Groups

`GET` /messages/{id}/groups

**Query**

| Parameter | Value |
|-----------|-------|
| page      | 0     |
| pageSize  | 0     |

**Response**
```json
{
  "result": {
    "content": [
      {
        "id": 123,
        "name": "string",
        "count":  0,
        "minAge": 0,
        "maxAge": 0,
        "minChildCount": 0,
        "maxChildCount": 0,
        "locations": [
          "string"
        ],
        "sources": [
          "string"
        ]
      }
    ],
    "pageable": {
      "pageSize": 100,
      "pageNumber": 0
    },
    "totalElements": 10000,
    "totalPages": 100,
    "last": false,
    "first": true
  }
}
```
