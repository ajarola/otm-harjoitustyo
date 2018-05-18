# **_Laivanupotus_**

Sovellus tarjoaa perinteisen laivanupotuspelin komentorivillä pelattavassa muodossa, sekä tallentaa muistiin tietoja pelatuista peleistä.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjaukset.md)

[Arkkitehtuuri](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Viimeisin release](https://github.com/ajarola/otm-harjoitustyo/releases/tag/Viikko7)

[Käyttöohje](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Testausdokumentti](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/testaus.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```

### Suoritettavan jar-tiedoston generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston.


### Checkstyle

Checkstyle tarkastukset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```
Testikattavuusraportti, JavaDoc sekä Checkstyle-raportti löytyvät generoimisen jälkeen _target_ hakemiston alta ja niiden tarkastelu kannattaa suorittaa selaimella.
