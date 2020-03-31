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
 - fuvarozás napja (bármely nap, vagy a következő 3 nap valamelyike)
 - az adott napon leghamarabb hány órától tud vállalni fuvarozást
 - csak Debrecenen belül szállít, vagy az egész megyében?
 - kapcsolati adatok

</dd>

<dt>alapanyag-felajánlás (raw material offering)</dt>
<dd>Alapanyag-beszállító (vagy egy koordinátor, egy alapanyag-beszállító nevében) hozza létre. Attribútumok:

 - cím (hova kell menni az alapanyagért)  
 - milyen alapanyag(ok)at tud felajánlani (szabadszöveges?)
 - az alapanyag biztosításának napja (bármely nap, vagy a következő 3 nap valamelyike)
 - meg tudja-e oldani az alapanyag(ok) szállítását (boolean) az étteremhez
 - fuvarozást meg tudja oldani?
 - fuvarozási igény (ha nem tudja megoldani, akkor kötelező megadni)
 - kapcsolati adatok
</dd>

<dt>Fuvarozás-igény</dt>
<dd>Készétel-felejánláshoz vagy alapanyag-felajánláshoz tartozik. Akkor kötelező megadni, ha a felajánló nem tudja megoldani az alapanyag vagy készétel elszállítását. Attribútumai:

 - (cím: honnan kell szállítani - ez számrmaztatott attribútum a készétel-felejánlás / alapanyag-felajánlás alapján)
 - leghamarabb mikorra lehet menni a szállítmányért? (óra:perc, dátum nélkül)
 - mekkora rakterű jármű kell?
 - hűtős jármű kell?
</dd>

<dt>Kiszállítási terv</dt>
<dd>A kiszállítási tervet egy koordinátor készíti el. Egy adott napra vonatkozó feladatokból áll. Minden feladatnak van egy felelőse, akinek már ismertek a kapcsolati adatai. Attribútumai:

 - dátum (nap)
 - ételkészítési feladat: egy ételkészítési felajánlással élve a koordinátor megbízza a felajánlót, hogy készítse el a felajánlott (vagy kevesebb?) adag ételt. Pontosan 1 ételkészítési feladat tarozik egy kiszállítási tervhez.
 - alapanyag-beszerzési feladatok: egy alapanyag-felajánlással élve a koordinátor megbízza a felajánlót, hogy biztosítsa időben a felajánlott alapanyagokat adott napon, adott időpontra. 0..n alapanyag-beszerzési feladat tartozik egy kiszállítási tervhez.
 - fuvarozási feladat: egy fuvarozási felajánlással élve a koordinátor megbíz egy fuvarozót, hogy készételt szállítson a kórházba. Egy kiszállítási tervhez akkor tartozik ilyen fuvarozási feladat, ha a az étterem-tulajdonos nem vállalja  a kiszállítást).
</dd>

<dt>Ételkészítési feladat</dt>
<dd>A koordinátor hozza létre egy ételkészítési felajánlás alapján. Attribútumok:

- felelős: az étterem-tulajdonos, akinek a felajánlását elfogadja a koordinátor
- adagok száma: maximum a felajánlásban megadott adagmennyiség lehet)
- fuvarozási feladat: kötelezően tartozik az ételkészítési feladathoz, ha az étterem-tulajdonos nem tudja megoldani a szállítást
</dd>

<dt>Alapanyag-beszerzési feladat</dt>
<dd>Attribútumok:

- felelős: az alapanyag-beszállító, akinek a felajánlását elfogadja a koordinátor
- a biztosított alapanyagok szabadszöveges leírása
- fuvarozási feladat: kötelező, ha nem vállalja az alapanyag-beszállító a szállítást az étterembe, egyébként nincs megadva
</dd>

<dt>Fuvarozási feladat</dt>
<dd>A koordinátor hozza létre egy fuvarozási felajánlás alapján. Vagy egy alapanyag-beszerzési feladathoz tartozik, vagy egy ételkészítési feladathoz. Attribútumai:

- felelős: a fuvarozó, akinek a felajánlását elfogadja a koordinátor
- becsült indulási időpont (mikorra kell a fuvarozónak megérkezni az indulási címre)
- feladó és címzett kapcsolati adatai (annak az alapanyag-beszállítónak vagy étterem-tulajdonosnak a kapcsolati adatai, akinek a címéről szállítani kell ill. ahova szállítani kell)
- címek (honnan hova)
</dd>
</dl>



## Welcome screen (látogatóknak)

(Statikus szöveg a csoport céljáról, stb)

Alatta 3 gomb felajánlóknak, szerep szerint. A gombok 3 különböző formra navigálnak, amelyeken a különböző típusú felajánlásokat lehet létrehozni.

### User scenario:
 * a látogató a welcome screen-re navigál
 * valamelyik szerepkör szerinti gombra kattint
 * kitölti a formot
 * elküldi a felajánlását
 * ...
 * később telefonon vagy emailben értesítést kap, ha egy koordinátor beillesztette a felajánlást egy kiszállítási tervbe


## Koordinátori felület

Authentikált koordinátorok láthatják.

### Kiszállítási tervező felület

A koordinátor itt tud összeállítani egy kiszállítási tervet.

#### User scenario: új kiszállítási terv létrehozása

* a koordinátor bejelentkezik
* kiválasztja, hogy melyik napra vonatkozó tervet készít (következő 3 nap valamelyike)
* megjelenik az adott napra érvényes készétel-felajánlások listája
* kiválasztja a készétel-felajánlást (így létrejön az ételkészítési feladat a kiszállítási tervhez)
* létrehozza az opcionális alapanyag-beszállítási és fuvarozási feladatokat (TODO UI)
* elmenti a kiszállítási tervet
* értesítések a felelősöknek?