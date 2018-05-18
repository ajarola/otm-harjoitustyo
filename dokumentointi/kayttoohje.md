# Käyttöohje

Lataa uusin [release](https://github.com/ajarola/otm-harjoitustyo/releases)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar laivanupotus.jar
```
Mitään muuta ei tarvita. Sovellus käynnistyy komentoriville ja tulostaa pelaajalle lyhyen käyttöohjeen. Tämän jälkeen sovelluksen ohjeiden mukaan pelaaja kirjoittaa oman nimimerkkinsä tilastointia varten sekä sijoittaa omat laivansa pelilaudalle haluamallaan tavalla. Tämän jälkeen peli alkaa. Peli loppuu kun toisen osapuolen kaikki laivat on tuhottu tai pelaaja lopettaa sen ennenaikaisesti ohjeistetulla syötteellä.

## Tulosten tallentaminen
Peli tallentaa automaattisesti pelituloksia _statistics.txt_ nimiseen tekstitiedostoon. Muistiin tallennetaan pelaajan nimimerkki, pelin tulos sekä käytettyjen vuorojen määrä. Tuloksia voi itse käydä halutessaan tarkastamassa kyseisestä tiedostosta.
