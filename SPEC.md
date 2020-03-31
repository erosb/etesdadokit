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
    <dd>Az étterem-tulajdonos hozza létre, attribútumai:
    
 - felajánlott étel megnevezése
 - hány adagot tud készíteni (min. 50)
 - kiszállítás napja (bármely nap, vagy a következő 3 nap valamelyike)
 - milyen fontosabb hozzávalók kellenek (szabadszöveges leírás)
 - meg tudja-e oldani az étel kiszállítását a kórházba (boolean)
 - étterem címe
 - kapcsolati adatok
    </dd>

    <dt>kapcsolati adatok</dt>
    <dd>Minden felajánlónak kötelező megadni. Ezeket kliensoldalon megjegyezzük, de authentikációra egyelőre semmit  nem használunk belőle. Attribútumai:

- cégnév vagy kapcsolattartó neve
- email cím
- telefonszám
    </dd>

    <dt>Fuvarozás felajánlás (shipping offering)</dt>
    <dd>Attribútumai:
    
- raktér mérete, vagy a jármű típusa
- hűtős autó? 
- fuvarozsá napja (bármely nap, vagy a következő 3 nap valamelyike)
- az adott napon leghamarabb hány órától tud vállalni fuvarozást
- csak Debrecenen belül szállít, vagy az egész megyében?
- kapcsolati adatok
    </dd>

    <dt>alapanyag-felajánlás</dt>
    <dd>Alapanyag-beszállító hozza létre. Attribútumok:
    
    
    </dd>
</dl>



## Publikus welcome screen

Statikus szöveg a csoport céljáról
Alatta 3 gomb felajánlóknak, szerep szerint
