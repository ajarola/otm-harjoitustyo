# **_Laivanupotus_**

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjaukset.md)

[Arkkitehtuuri](https://github.com/ajarola/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Release](https://github.com/ajarola/otm-harjoitustyo/releases/tag/Viikko5)

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
Testikattavuusraportti, Javadoc sekä Checkstyle-raportti löytyvät generoimisen jälkeen _target_ hakemiston alta.

```
