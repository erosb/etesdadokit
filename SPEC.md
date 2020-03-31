# EtesdADokit specifikáció


## Terminológia / fogalomtár


### Szerepkörök
<dl>
 <dt>látogató</dt>
 <dd>bárki, aki a weblapra navigál, nem authentikált felhasználó</dd>

 <dt>felajánló (offerer? donor?)</dt>
 <dd>ebbe a szerepkörbe azok a felhasználók tartoznak, akik kitöltötték valamelyik felajánló formot. A felajánlás típusa szerint lehet a felajánló:
 
 - alapanyag-beszállító
 - vagy fuvarozó
 - vagy étterem-tulajdonos (/ételkifőzde / pékség ... ennek mi legyen az összefoglaló neve?)

A felajánlókat nem authentikáljuk, viszont a rendszer a kapcsolati adataikat tárolja (név, email cím, telefonszám), ill. a böngésző kliens-oldalon megjegyzi, így ha valaki többször akar felajánlást tenni, akkor ehhez nem kell újra megadnia ezeket az adatokat).
  </dd>

  <dt>koordinátor</dt>
  <dd>
    Ők a kórházi dolgozók ill. kapcsolattartók, akik fogadják és kezelik az adományokat, és megszervezik a napi kiszállításokat. Egy authentikált felületen keresztül látják ezeket napi (?) bontásban, a felajánlásokat excel fájlba exportálva le tudják tölteni, ill. napi kiszállításokat tudnak megtervezni.
  </dd>

</dl>

### Kiszállítással kapcsolatos fogalmak

<dl>
    <dt>készétel-felajánlás (food offering)</dt>
    <dd>Az étterem-tulajdonos (vagy egy koordinátor, egy étterem-tulajdonos nevében) hozza létre, attribútumai:
    
  - felajánlott étel megnevezése
  - hány adagot tud készíteni (min. 50)
  - kiszállítás napja (bármely nap, vagy a következő 3 nap valamelyike)
  - milyen fontosabb hozzávalók kellenek (szabadszöveges leírás)
  - meg tudja-e oldani az étel kiszállítását a kórházba (boolean)
  - fuvarozási igény (ha nem tudja megoldani a fuvarozást, akkor ezt kötelező megadni)
  - étterem címe
  - kapcsolati adatok

</dd>

<dt>kapcsolati adatok</dt>
    <dd>Minden felajánlónak kötelező megadni. Ezeket kliensoldalon megjegyezzük, de authentikációra egyelőre semmit  nem használunk belőle. Attribútumai:

 - cégnév vagy kapcsolattartó neve
 - email cím
 - telefonszám
</dd>

<dt>Fuvarozás/szállítás felajánlás (shipping offering)</dt>
<dd>Attribútumai:
    
 - raktér mérete, vagy a jármű típusa
 - hűtős autó? 
 - fuvarozsá napja (bármely nap, vagy a következő 3 nap valamelyike)
 - az adott napon leghamarabb hány órától tud vállalni fuvarozást
 - csak Debrecenen belül szállít, vagy az egész megyében?
 - kapcsolati adatok

</dd>

<dt>alapanyag-felajánlás (raw material offering)</dt>
<dd>Alapanyag-beszállító (vagy egy koordinátor, egy alapanyag-beszállító nevében) hozza létre. Attribútumok:

 - cím (hova kell menni az alapanyagért)  
 - milyen alapanyag(ok)at tud felajánlani (szabadszöveges?)
 - meg tudja-e oldani az alapanyag(ok) szállítását (boolean) az étteremhez
 - fuvarozást meg tudja oldani?
 - fuvarozási igény (ha nem tudja megoldani, akkor kötelező megadni)
 - kapcsolati adatok
</dd>

<dt>Fuvarozás-igény</dt>
<dd>Készétel-felejánláshoz vagy alapanyag-felajánláshoz tartozik. Akkor kötelező megadni, ha. Attribútumai:

 - cím: honnan kell szállítani
 - leghamarabb mikorra lehet menni a szállítmányért? (óra:perc, dátum nélkül)
 - mekkora rakterű jármű kell?
 - hűtős jármű kell?
</dd>

<dt>Kiszállítási terv</dt>
<dd>A kiszállítási tervet egy koordinátor készíti el. Egy adott napra vonatkozó feladatokból áll. Attribútumai:

 - ételkészítési feladat: egy ételkészítési felajánlással élve a koordinátor megbízza a felajánlót, hogy készítse el a felajánlott (vagy kevesebb?) adag ételt. Pontosan 1 ételkészítési feladat tarozik egy kiszállítási tervhez.
 - alapanyag-beszerzési feladat: egy alapanyag-felajánlással élve a koordinátor megbízza a felajánlót, hogy biztosítsa időben a felajánlott alapanyagokat adott napon, adott időpontra.
</dd>

<dt>Ételkészítési feladat</dt>
<dd>A koordinátor hozza létre egy ételkészítési felajánlás alapján. Attribútumok:

- adagok száma: maximum a felajánlásban megadott adagmennyiség lehet
</dd>

<dt>Alapanyag-beszerzési feladat</dt>
<dd></dd>

<dt>Fuvarozási feladat</dt>
<dd>A koordinátor hozza létre egy fuvarozási felajánlás alapján. Vagy egy alapanyag-beszerzési feladathoz tartozik, vagy egy ételkészítési feladathoz. Attribútumai:

- fuvarozó (akinek a felajánlását elfogadja a koordinátor)
- feladó kapcsolati adatai (annak az alapanyag-beszállítónak vagy étterem-tulajdonosnak a kapcsolati adatai, akinek a címéről szállítani kell)
- címek
</dd>
</dl>



## Publikus welcome screen

Statikus szöveg a csoport céljáról
Alatta 3 gomb felajánlóknak, szerep szerint. A gombok 3 különböző formra navigálnak, amelyeken a különböző típusú felajánlásokat lehet létrehozni.

## Koordinátori felület


