import requests

http="http://"



def test_get_production_serie():
    url = http+"localhost:8080/production/serie"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)
    assert "Breaking Bad" in response.text

def test_get_production_serie_title():
    url = http+"localhost:8080/production/serie?title=Breaking Bad"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Breaking Bad" in response.text

def test_get_production_serie_title_substring():
    url = http+"localhost:8080/production/serie?title=Bad"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Breaking Bad" in response.text


def test_get_production_serie_author():

    url = http+"localhost:8080/production/serie?author=Vince Gilligan"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Breaking Bad" in response.text


def test_get_production_serie_author_substring():

    url = http+"localhost:8080/production/serie?author=Vince"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Breaking Bad" in response.text


def test_get_production_serie_status():
    url = http+"localhost:8080/production/serie?status=Finished"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "Breaking Bad" in response.text


