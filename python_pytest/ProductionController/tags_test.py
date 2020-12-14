import requests

http="http://"


def test_post_tag_id():

    url = http+"localhost:8080/production/tag/1?tags=action"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/production/1"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'action' in response.text


def test_delete_tag_id():

    url = http+"localhost:8080/production/tag/26"

    payload={}
    headers = {'session_id': '1'}

    response = requests.request("POST", url, headers=headers, data=payload)

    url = http+"localhost:8080/production/anime"

    payload={}
    headers = {}

    response = requests.request("DELETE", url, headers=headers, data=payload)

    assert 'action' not in response.text
