<h1>
<a id="user-content-pflichtübung-4-bundesnachrichtendienst-100-punkte" class="anchor" href="#pflicht%C3%BCbung-4-bundesnachrichtendienst-100-punkte" aria-hidden="true"><span class="octicon octicon-link"></span></a>Pflichtübung 4: Bundesnachrichtendienst [100 Punkte]</h1>

<ul>
<li>Ausgabe: 13.5.2015</li>
<li>Abgabe: 02.06.2015 23:59 Uhr (Bereitstellen auf GitHub)</li>
<li>Testat: 4.6.2015 (11:45 - 14:00 Uhr)</li>
</ul>

<h2>
<a id="user-content-problembeschreibung" class="anchor" href="#problembeschreibung" aria-hidden="true"><span class="octicon octicon-link"></span></a>Problembeschreibung</h2>

<p>Sie erwachen aus einem tiefen Schlaf und merken, dass Metropolis doch nur ein Traum war. Schade, hatten Sie sich doch gerade mit dieser Welt angefreundet.Ihr Magen knurrt, Sie brauchen dringend wieder eine Anstellung, damit Sie Ihr Essen bezahlen können. Glücklicherweise sucht der Bundesnachrichtendienst (BND) im Augenblick dringend Informatiker.</p>

<p>Ihre Aufgabe besteht darin, eine Verschlüsselungssoftware für den BND zu entwickeln. Sie haben zwar den Verdacht, dass damit geheime Unterlagen zur Zusammenarbeit mit der NSA verschlüsselt werden sollen, ignorieren aber alle Skrupel und stürzen sich in Ihre Aufgabe.</p>

<p>Das Interface für die neue Verschlüsselungssoftware ist bereits vor Ihrer Einstellung beim BND definiert worden und befindet sich auf GitHub.</p>

<p><a href="/tpe-lecture/exercises/blob/master/exercise4/src/Crypter.java">Crypter.java</a></p>

<p>Sie müssen das Interface exakt so verwenden, wie es vorgegeben ist, verändern Sie es also auf keinen Fall. Andernfalls laufen Sie Gefahr, den Geheimdienst gegen sich aufzubringen und was dann passiert kennen Sie bereits sehr gut aus dem Kino.</p>

<p>Implementieren Sie das Interface <code>Crypter</code> und stellen Sie verschiedene Verschlüsselungsimplementierungen zur Verfügung und zwar für eine</p>

<ul>
<li>Caesar-Verschlüsselung,</li>
<li>Substitutionschiffre und </li>
<li>XOR-Verschlüsselung.</li>
</ul>

<p>Erstellen Sie eine Factory-Klasse <code>CrypterFactory</code> mit der man die verschiedenen Verschlüsselungsimplementierungen erzeugen kann. Verwenden Sie für die Auswahl der Implementierung in der Factory eine <em>Enumeration</em> <code>CrypterVerfahren</code> mit den Konstanten <code>CAESAR</code>, <code>SUBSTITUTION</code> und <code>XOR</code>.</p>

<p>Implementieren Sie die im Interface benutzte Ausnahmen <code>IllegalKeyException</code> und <code>IllegalMessageExcpetion</code> .</p>

<p>Verbergen Sie die Implementierung vor dem Verwender und erlauben Sie ihm nur den Zugriff auf die Factory, das Interface selbst und die Ausnahmen. Wählen Sie entsprechende Pakete gemäß Ihrem Schema.</p>

<p><strong>Tipp</strong>: Denken Sie daran, keinen Code zu duplizieren und führen Sie gegebenenfalls weitere Klasse ein, um dies zu vermeiden.</p>

<h3>
<a id="user-content-caesar-verschlüsselung" class="anchor" href="#caesar-verschl%C3%BCsselung" aria-hidden="true"><span class="octicon octicon-link"></span></a>Caesar-Verschlüsselung</h3>

<p>Implementieren Sie die <em>Caesar-Verschlüsselung</em> mit Hilfe einer Klasse <code>CrypterCaesar</code>, die das Interface <code>Crypter</code> implementiert. Das Verschlüsselungsverfahren funktioniert wie folgt <a href="https://de.wikipedia.org/wiki/Caesar-Verschl%C3%BCsselung">Quelle Wikipedia</a>:</p>

<p>Ordnet man den Buchstaben des Alphabets Zahlen zu, wie beispielsweise in der folgenden Tabelle, so lässt sich mithilfe eines "Schlüsselbuchstabens" angeben, um wie viele Zeichen das Standardalphabet verschoben werden muss, um das Geheimalphabet zu erhalten:</p>

<pre><code>A B C D E F G H I J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
</code></pre>

<p>Beispielsweise entspricht der Schlüssel "C" einer zyklischen Verschiebung um drei Zeichen. Folglich wird beispielsweise der Klarbuchstabe "R" als Geheimbuchstabe "U" verschlüsselt. Somit ergibt sich folgende Zuordnung:</p>

<pre><code>Klar:    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Geheim:  D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
</code></pre>

<p>Aus dem Klartext "CAESAR" wird bei Verschlüsselung mit dem Schlüssel "C" der Geheimtext "FDHVDU".</p>

<p>Im Falle der Caesar-Verschlüsselung enthält der Schlüssel nur ein einziges Zeichen, das den Verschiebefaktor angibt.</p>

<h3>
<a id="user-content-subsitutionschiffre" class="anchor" href="#subsitutionschiffre" aria-hidden="true"><span class="octicon octicon-link"></span></a>Subsitutionschiffre</h3>

<p>Implementieren Sie einen <em>Substitutionschiffre</em> mit Hilfe der Klasse <code>CrypterSubstitution</code>, die das Interface <code>Crypter</code> implementiert. Das Verschlüsselungsverfahren funktioniert wie folgt <a href="https://de.wikipedia.org/wiki/Monoalphabetische_Substitution">Quelle Wikipedia</a>:</p>

<p>Ein Beispiel für eine monoalphabetische Verschlüsselung [Substitutions-Chiffre] ist das folgende Verfahren. Hierbei werden einzelne Buchstaben des Klartextes mithilfe des Schlüsselalphabets in einzelne Zeichen des Geheimtextes substituiert. </p>

<pre><code>Klartext:   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Schlüssel:  U F L P W D R A S J M C O N Q Y B V T E X H Z K G I
</code></pre>

<p>Aus dem Klartext "WIKIPEDIAISTINFORMATIV" wird nach Verschlüsselung der Geheimtext "ZSMSYWPSUSTESNDQVOUESH". Der Klartext lässt sich durch Entschlüsselung wieder aus dem Geheimtext rekonstruieren, indem man dort die Buchstaben in der zweiten Zeile durch die der ersten Zeile ersetzt. </p>

<p>Im Falle der Substitutions-Chiffre enthält der Schlüssel genau 26 Zeichen, wobei jedes Zeichen (A-Z) nur ein mal vorkommen darf.</p>

<h3>
<a id="user-content-xor-verschlüsselung" class="anchor" href="#xor-verschl%C3%BCsselung" aria-hidden="true"><span class="octicon octicon-link"></span></a>XOR-Verschlüsselung</h3>

<p>Implementieren Sie ein Verschlüsselung, die auf der Verknüpfung von Text und Schlüssel per XOR basiert. Die Implementierung nennen Sie bitte <code>CrypterXOR</code>. Das Verfahren funktioniert wie folgt: </p>

<p>Bei der XOR-Verschlüsselung werden Klartext und Schlüssel per XOR miteinander verknüpft. Der Schlüssel kann ein beliebig langer Text sein. Wenn der Klartext länger als der Schlüssel ist, wird der Schlüssel einfach wiederholt. Die Zahlenwerte von Schlüssel und Klartext werden per XOR miteinander verknüpft. Die Entschlüsselung funktioniert genauso, indem wieder der verschlüsselte Text und der Schlüssel per XOR miteinander verknüpft werden. </p>

<p>Beispielsweise würde beim Schlüssel "TPERULES" bei der Verschlüsselung folgendes passieren:</p>

<pre><code>Klartext:
    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z  
    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 
Schlüssel:
    T  P  E  R  U  L  E  S  T  P  E  R  U  L  E  S  T  P  E  R  U  L  E  S  T  P  
    20 16 5  18 21 12 5  19 20 16 5  18 21 12 5  19 20 16 5  18 21 12 5  19 20 16 
Ergebnis:
    U  R  F  V  P  J  B  [  ]  Z  N  ^  X  B  J  C  E  B  V  F  @  Z  R  K  M  J  
    21 18 6  22 16 10 2  27 29 26 14 30 24 2  10 3  5  2  22 6  0  26 18 11 13 10 
</code></pre>

<p>Bei der Entschlüsselung wird der Schlüssel erneut per XOR auf den verschlüsselten Text angewendet:</p>

<pre><code>Verschlüsselter Text:
    U  R  F  V  P  J  B  [  ]  Z  N  ^  X  B  J  C  E  B  V  F  @  Z  R  K  M  J  
    21 18 6  22 16 10 2  27 29 26 14 30 24 2  10 3  5  2  22 6  0  26 18 11 13 10 
Schlüssel:
    T  P  E  R  U  L  E  S  T  P  E  R  U  L  E  S  T  P  E  R  U  L  E  S  T  P  
    20 16 5  18 21 12 5  19 20 16 5  18 21 12 5  19 20 16 5  18 21 12 5  19 20 16 
Ergebnis:
    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z  
    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26  
</code></pre>

<p>Das Ergebnis entsteht durch das XOR-Verknüpfen der Zahlenwerte, z.B. wird "A" mit "T" verschlüsselt, indem man <code>1 ^ 20 = 21</code> rechnet. Die Entschlüsselung erfolgt dann umgekehrt, d.h. <code>21 ^ 20 = 1</code>, womit sich wieder ein "A" ergibt.</p>

<p>Beachten Sie, dass bei der XOR-Verschlüsselung der Schlüssel beliebig lang werden kann. Außerdem brauchen Sie zur Darstellung des verschlüsselten Textes mehr als 26 Buchstaben, nämlich 32. Nehmen Sie daher einfach noch die folgenden Zeichen mit auf: <code>@=0, [=27, \=28, ]=29, ^=30 und _=31</code></p>

<h2>
<a id="user-content-test" class="anchor" href="#test" aria-hidden="true"><span class="octicon octicon-link"></span></a>Test</h2>

<p>Schreiben Sie automatisierte JUnit-Tests mit denen Sie die korrekte Funktionsweise der Implementierungen und der Factory-Klasse überprüfen. Legen Sie die Tests in ein anderes Paket als die Verschlüsselungsklassen. Denken Sie daran, auch die Ausnahmen zu testen.</p>

<h2>
<a id="user-content-entschlüsseln-einer-geheimen-botschaft" class="anchor" href="#entschl%C3%BCsseln-einer-geheimen-botschaft" aria-hidden="true"><span class="octicon octicon-link"></span></a>Entschlüsseln einer geheimen Botschaft</h2>

<p>Entschlüsseln Sie nun eine geheime Botschaft und geben Sie den Klartext aus.</p>

<p>Die Botschaft lautet:</p>

<pre><code>RXZL_FO\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\PQTQAEXAODQAXZRQBQEA[HLZW
</code></pre>

<p>Der Klartext wurde zuerst mit dem Schlüssel "POIUZTREWQMNBVCXYLKJHGFDSA" mit einer Subsitituionschiffre verschlüsselt, danach mit einer Caesar-Verschlüsselung mit dem Schlüssel "T" und abschließend durch eine XOR-Verschlüsselung mit dem Schlüssel "WINTERISCOMING".</p>

<h2>
<a id="user-content-abgabe" class="anchor" href="#abgabe" aria-hidden="true"><span class="octicon octicon-link"></span></a>Abgabe</h2>

<p>Laden Sie Ihre Quelltexte zum Testat auf GitHub hoch. Ihre Tests und die entschlüsselte, geheime Botschaft müssen Sie im Testat vorführen.</p>
