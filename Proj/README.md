```
Restaurant Menu Builder

Pentru proiectul individual vreau sa fac o aplicatie in care se poate construi si administra meniul unui restaurant. M-am gandit la tema asta pentru ca un meniu are o structura de arbore destul de clara: meniul e radacina, sub el sunt categoriile, iar in fiecare categorie sunt preparatele.

Un meniu poate avea mai multe categorii, de exemplu aperitive, ciorbe, feluri principale, desert sau bauturi. Fiecare categorie are preparatele ei, iar la fiecare preparat se pun urmatoarele informatii:
- numele preparatului
- o descriere scurta (ce contine, cum e preparat)
- o poza cu preparatul
- alergenii pe care ii contine (gluten, lactoza, oua, nuci etc.)
- pretul in lei

Functionalitati:

Add - se poate crea un meniu nou, se pot adauga categorii intr-un meniu si preparate intr-o categorie.

View - se poate vedea tot meniul cu toate categoriile si preparatele lui, dar si doar o anumita categorie sau detaliile unui singur preparat.

Summary - pentru un meniu se poate genera un rezumat care arata cate categorii are, cate preparate sunt in fiecare categorie, care e cel mai ieftin si cel mai scump preparat, pretul mediu si lista cu toti alergenii care apar in meniu. Asta ar fi util de exemplu pentru clientii cu alergii, ca sa vada rapid ce alergeni sunt in meniu.

Partea tehnica:
- backend-ul o sa fie un REST API facut cu Spring Boot
- datele o sa fie salvate intr-o baza de date H2, folosind Spring Data JPA
- interfata o sa fie o pagina web simpla in HTML si JavaScript, din care se pot adauga si vedea meniurile

Vreau sa folosesc si cateva din design pattern-urile facute la laborator: Composite pentru structura de arbore, Visitor pentru calcularea summary-ului si Proxy pentru incarcarea pozelor doar cand e nevoie de ele.

Proiectul o sa il fac pe mai multe branch-uri in git, cate unul pentru fiecare functionalitate (modelul de date, add, view, summary, interfata), si dupa fiecare o sa fac merge in main.
```