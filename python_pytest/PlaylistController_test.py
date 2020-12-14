import requests


http="http://"


def test_post_playlist():
    url = http+"localhost:8080/playlists/?playlistName=para assistir&usuarioId=2"

    payload={} 
    headers = {}

    response = requests.request("POST", url, headers=headers, data=payload)

    assert 'para assistir' in response.text

def test_patch_playlist():
    url = http+"localhost:8080/playlists/2/?name=to-watch"

    payload={}
    headers = {}

    response = requests.request("PATCH", url, headers=headers, data=payload)

    url = http+"localhost:8080/playlists/"

    response = requests.request("GET", url, headers=headers, data=payload)

    assert  'to-watch' in response.text


def test_get_playlist_name():
    url = http+"localhost:8080/playlists/favoritos"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert "favoritos" in response.text


def test_get_playlist_all():

    url = http+"localhost:8080/playlists/"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'favoritos' in response.text


def test_get_playlist_production():
    
    url = http+"localhost:8080/playlists/production/One Piece"

    payload={}
    headers = {}

    response = requests.request("GET", url, headers=headers, data=payload)

    assert 'favoritos' in response.text


def test_delete_playlist():
    url = http+"localhost:8080/playlists/2/"

    payload={}
    headers = {}

    response = requests.request("DELETE", url, headers=headers, data=payload)

    assert "to-watch" not in response.text
