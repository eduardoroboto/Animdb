import requests

http="http://"


def test_post_casting_id():
    url = http+"localhost:8080/production/cast/2?cast=Bryan Cranston"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/production/serie?title=Breaking Bad"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'Bryan Cranston' in response.text


def test_put_cast_id():
    url = http+"localhost:8080/production/cast/1"

    payload=" {\n    \"actor\": \"Bryan Cranston - Water White\",\n    \"productionId\": 2\n}"
    headers = {'session_id': '1','Content-Type': 'application/json'}

    response = requests.request("PUT", url, headers=headers, data=payload)

    
    url = http+"localhost:8080/production/serie?title=Breaking Bad"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'Water White' in response.text


def test_delete_cast_id():
    url = http+"localhost:8080/production/cast/1"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("DELETE", url, headers=headers, data=payload)

    assert 'Bryan Cranston' not in response.text


