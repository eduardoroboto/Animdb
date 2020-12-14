import requests

http="http://"



def test_get_production_anime():
    url = http+"localhost:8080/production/anime"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text

def test_get_production_anime_title():
    url = http+"localhost:8080/production/anime?title=One Piece"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text

def test_get_production_anime_title_substring():
    url = http+"localhost:8080/production/anime?title=One"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text


def test_get_production_anime_author():

    url = http+"localhost:8080/production/anime?author=Eichiirou Oda"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text


def test_get_production_anime_author_substring():

    url = http+"localhost:8080/production/anime?author=Oda"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text


def test_get_production_anime_status():
    url = http+"localhost:8080/production/anime?status=Airing"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "One Piece" in response.text


