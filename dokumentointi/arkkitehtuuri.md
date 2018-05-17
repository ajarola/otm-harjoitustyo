# Arkkitehtuurikuvaus
## Pakkausrakenne
Pakkausrakenne on yksinkertainen ja koostuu vain ja ainoastaan eri pakkauksissa olevasta sovelluslogiikasta sekä käyttöliittymästä.

![Paukkausrakenne](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/pakkaus.png)
## Luokkakaavio
Sovelluksen rakenne esitettynä luokkakaavion avulla. Luokkiin on merkitty niiden attribuuttien nimet, mutta ei selkeyden vuoksi metodeita.
![Luokkakaavio](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png)
## Käyttöliittymä
Sovelluksen käyttöliittymän muodostaa GameUi luokka, joka sijaitsee pakkauksessa ui ja jossa tapahtuu varsinainen pelitapahtuma sekä käyttäjälle näkyvät tulostukset. Käyttöliittymä on komentorivipohjainen tekstikäyttöliittymä, joka ottaa käyttäjältä syötteenä pelin asetukset sekä peliin liittyvät siirrot.

## Sovelluslogiikka
Varsinainen sovelluslogiikka on pakkauksessa laivanupotus ja koostuu pelin toiminnan kannalta välttämättömistä Board-, Player- sekä Ship- luokista, sekä pelitapahtuman tulosten tallentamisen mahdollistavasta Statistics-luokasta. Kolmen ensimmäisenä mainitun luokan testaus on hoidettu automaattisten testien avulla. Alla esimerkkinä sekvenssikaaviona yksi sovelluksen tärkeimmistä toiminnallisuuksista pelin onnistumisen kannalta, laivojen sijoittaminen pelikentälle.

### Sekvenssikaavio
randomBoard()-metodia käytetään vastustajan sekä valinnaisesti oman pelilaudan täyttämiseen satunnaisesti laivoilla.
![Sekvenssikaavio satunnaisen pelilaudan tuottamisesta](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Sekvenssikaavio.png)
