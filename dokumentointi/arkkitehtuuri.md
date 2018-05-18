# Arkkitehtuurikuvaus
## Pakkausrakenne
Pakkausrakenne on yksinkertainen ja koostuu vain ja ainoastaan eri pakkauksissa olevasta sovelluslogiikasta sekä käyttöliittymästä. Tämän lisäksi testeillä on oma pakkauksensa.

![Paukkausrakenne](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/pakkaus.png)
## Luokkakaavio
Sovelluksen rakenne esitettynä luokkakaavion avulla. Luokkiin on merkitty niiden attribuuttien nimet, mutta ei selkeyden vuoksi metodeita.
![Luokkakaavio](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png)
## Käyttöliittymä
Sovelluksen käyttöliittymän muodostaa GameUi luokka, joka sijaitsee pakkauksessa ui ja jossa tapahtuu varsinainen pelitapahtuma sekä lähes kaikki käyttäjälle näkyvät tulostukset. Käyttöliittymä on komentorivipohjainen tekstikäyttöliittymä, joka ottaa käyttäjältä syötteenä pelin asetukset sekä peliin liittyvät siirrot, ohjeistaen samalla niiden antamisessa. Sen toiminnan testaus on suoritettu manuaalisesti.

## Sovelluslogiikka
Varsinainen sovelluslogiikka on pakkauksessa laivanupotus ja koostuu pelin toiminnan kannalta välttämättömistä Board-, Player- sekä Ship- luokista, sekä pelitapahtuman tulosten tallentamisen mahdollistavasta Statistics-luokasta. Näiden mainittujen luokkien testaus on hoidettu automaattisten testien avulla, jotka löytyvät testikohteensa mukaan nimetyistä testiluokista, jotka ovat testipakkauksessa. Alla esimerkkinä sekvenssikaaviona yksi sovelluksen tärkeimmistä toiminnallisuuksista pelin onnistumisen kannalta, laivojen sijoittaminen pelikentälle. Toiminnallisuus on pyritty jakamaan eri luokkiin ja huomattavan pitkiä metodeita on soveltuvin osin pilkottu pienemmiksi kokonaisuuksiksi.

### Sekvenssikaavio
randomBoard()-metodia käytetään vastustajan sekä valinnaisesti oman pelilaudan täyttämiseen satunnaisesti laivoilla.
![Sekvenssikaavio satunnaisen pelilaudan tuottamisesta](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Sekvenssikaavio.png)
