# PoM
Το PeersOnMap είναι μια εφαρμογή για Android κινητές συσκευές, που βασίζεται στις συνεισφορές των χρηστών με σκοπό τη δημιουργία ενός χάρτη περισσότερρο φιλικού για πεζούς και ποδηλάτες. Η εφαρμογή προτρέπει τους χρήστες με τη βοήθεια της παιχνιδοποίησης, να ανεβάσουν τα μονοπάτια τους όσο περπατούν ή κάνουν ποδήλατο. Η Ομότιμη Αξιολόγηση (Peer Review) αποτελεί βασικό εργαλείο της εφαρμογής PeersOnMap και βοηθά στη βελτίωση των παραγόμενων χαρτών. Οι χρήστες έχουν τη δυνατότητα μέσα από τη φυσική παρουσία τους σε μια περιοχή, να αξιολογήσουν ή να σχεδιάσουν διορθώσεις για καταγεγραμμένα μονοπάτια που εμφανίζονται στο χάρτη. Ο τελικός στόχος είναι να δημιουργηθεί ένας εναλλακτικός αστικός χάρτης για πεζούς και ποδηλάτες.<br/>
Σημείο έναρξης του συστήματος είναι το σύστημα [PathsOnMap](https://github.com/ippokratis1/PathsOnMap-Corfu-client.git)
 
Εδώ παρουσιάζεται ο client της εφαρμογής.<br/>
Στην αρχική οθόνη φαίνονται όλες τις διαδρομές που έχουν καταγράψει οι χρήστες έως τώρα και επιτρέπει την έναρξη καταγραφής μιας νέας διαδρομής: <br />
![mainscreen1](https://user-images.githubusercontent.com/8918882/30755780-9e57167c-9fd0-11e7-9755-1168499128e3.png)
<br />

Όταν ο χρήστης ολοκληρώσει μια διαδρομή, ενημερώνεται για τους πόντους που θα κερδίσει αν την ανεβάσει, ενώ έχει και τη δυνατότητα να την απορρίψει: <br />
![record_end1](https://user-images.githubusercontent.com/8918882/30755828-cd2feb7c-9fd0-11e7-9e89-521950f6ac44.png)
<br />

Επίσης, ο χρήστης μπορεί ανά πάσα στιγμή να ελέγξει τους πόντους, τα επιτεύγματα και την κατάταξη του στο συνδεδεμένο Google Play Game: <br />
![leaderboard1](https://user-images.githubusercontent.com/8918882/30755843-d8f78cf8-9fd0-11e7-8de1-53f8288165ae.png)
![achievements1](https://user-images.githubusercontent.com/8918882/30755849-e13fd97e-9fd0-11e7-9ae3-3f4c17da2339.png)
 <br />
 
Επιπλέον, ο χρήστης έχει τη δυνατότητα να αξιολογήσει ή να σχεδιάσει μια διόρθωση για κάποιο από τα μονοπάτια που βρίσκονται γύρω από την τρέχουσα θέση του: <br />
![review1](https://user-images.githubusercontent.com/8918882/30755864-e915bd94-9fd0-11e7-9992-9004025895db.png)
![suggest1](https://user-images.githubusercontent.com/8918882/30755886-f5c76664-9fd0-11e7-983b-6305c7257c58.png)
<br />

Από την οθόνη ρυθμίσεων, μπορεί να γίνει παραμετροποίηση της εφαρμογής: <br />
![settings1](https://user-images.githubusercontent.com/8918882/30755897-fc90dd86-9fd0-11e7-9a0e-75bf07a43f04.png)
 <br />
 
Τέλος, υπάρχει δυνατότητα εμφάνισης του χάρτη πεζών ή ποδηλατών που έχει δημιουργηθεί ως τώρα.
 <br />


## Λήψη ##
Μπορείτε να κατεβάσετε την εφαρμογή απευθείας από το: https://peersonmap.herokuapp.com/ :<br />
![webpage](https://user-images.githubusercontent.com/8918882/30753420-ed7e4526-9fc7-11e7-9bc6-b6d8a2601216.png)
 <br />

## Τεχνολογίες και εργαλεία ##

Οι τεχνολογίες και τα εργαλεία που ενσωματώνει ο client του PeersOnMap είναι:

 - Android Studio
 - Java
 - Android SDK
 - XML
 - GPX
 - JSON
 - Google Maps Android API
 - Google Android Fused Location Provider API
 - Google Maps Roads API (Nearest Roads and Snap to Roads)
 - Google Play Game Services Android API
 - Google Firebase Android SDK

## Κατασκευή κώδικα ##

 1. Εγκατάσταση [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 2. Λήψη του [Android Studio](https://developer.android.com/studio/index.html#downloads). Κατεβάστε και τρέξτε την προεπιλεγμένη version η οποία περιλαμβάνει και το Android SDK. 
 3. Κατά το πρώτο άνοιγμα του Android Studio ακολουθηστε τον οδηγό και περιμένετε μέχρι να ολοκληρωθεί η λήψη των απαραίτητων components. Στη συνέχεια από το αρχικό παράθυρο πατήστε στο κάτω μέρος το *Configure* και από τη λίστα που εμφανίζεται επιλέξτε το Android SDK Manager. Από το νέο παράθυρο που εμφανίζεται θα πρέπει να επιλεγούν για εγκατάσταση οι απαιτούμενες από την εφαρμογή βιβλιοθήκες και τα εργαλεία. Συγκεκριμένα από την καρτέλα SDK Platforms επιλέξτε τα ακόλουθα:
 
- Android 7.1.1 (API 15)
- Android 7.0 (API 24)
- Android 6.0 (API 23)
- Android 5.1 (API 22)
- Android 5.0 (API 21)
- Android 4.4 (API 16)
- Android 4.3 (API 18)
- Android 4.2 (API 17)
- Android 4.1 (API 16)
 
 και από την καρτέλα SDK Tools τα ακόλουθα:
 
 - Android SDK build tools 25.0.0
 - Android SDK Platform-tools 25.0.3
 - Android SDK Tools 25.2.5
 - Android Support Library 23.2.1
 - Google Play Services 39
 - Google USB Driver 11.0.0
 - Support Repository ConstraintLayout for Android  1.0.0-alpha4
 - Support Repository Solver for ConstraintLayout 1.0.0-alpha4
 - Android Support Repository 44.0.0
 - Google Repository 44
 
 στη συνέχεια πατήστε το κουμπί apply, όπου ζητηθεί πατήστε αποδοχή και περιμένετε να ολοκληρωθεί η εγκατάσταση. Εναλλακτικά μπορείτε να εγκαταστήσετε τα παραπάνω και μετά το άνοιγμα του projerct είτε από το κουμπί Android SDK Manager από την μπάρα εργαλείων του Android Studio είτε από τη διαδρομή *Tools-->Android-->SDK Manager*.
 
 4. **Εισαγωγή κώδικα στο Android Studio:**  Κατεβάστε (download zip) το project από [εδώ](https://github.com/antpapapolyzos/PoM-client.git), αποσυμπιέστε το σε ένα φάκελο και αλλάξτε το όνομα του root directory (PoM-client-master) σε PoM. Από το αρχικό παράθυρο εισόδου του Android Studio πατήστε το *Open an existing Android Studio project* και επιλέξτε το φάκελο που αποθηκεύσατε το project. Αλλάξτε το path του jdk από το μενού του Android Studio στο *File-->Project Structure* και επιλέξτε αριστερά το SDK Location και δεξιά στο JDK location απο-επιλέξτε το Use embedded JDK και ορίστε το path που είναι αποθεκευμένο το JDK στον υπολογιστή σας. Σε περίπτωση εμφάνισης του σφάλματος *Unable to start the daemon process.*, ανοίξτε το gradle.properties από το παράθυρο Project που εμφανίζεται δεξιά και αλλάξτε την τιμή του org.gradle.jvmargs σε -Xxx1024m.
 5. **Εξαγωγή SHA1 fingerprint της εφαρμογής**: Στο Android Studio από το μενού *Build-->Generate Signed APK* και στο παράθυρο που εμφανίζεται πατήστε το κουμπί *Create new*. Στο νέο παράθυρο επιλέξτε το φάκελο και το όνομα που θα αποθηκευτεί το Key και στη συνέχεια συμπληρώστε τα απαιτούμενα στοιχεία και πατήστε OK, 	Next και Cancel. Από το μενού *File-->Project Structure* επιλέξτε το app στο Modules και στη συνέχεια στην καρτέλα Signing καταχωρήστε τα στοιχεία του Key που δημιουργήσατε νωρίτερα και πατήστε OK. Στο πλαίσιο που ανοίγει πατώντας στο Gradle στη δεξιά πλευρά του Android Studio πατήστε το PoM-->Tasks-->android-->signingReport και στο πλαίσιο Run στο κάτω μέρος θα εμφανιστεί το SHA1 fingerprint της εφαρμογής π.χ.: A6:4E:77:0F:EC:CF:A6:15:D7:05:CD:C1:95:21:2B:00:50:4C:53:02.
 6. **Ρυθμίσεις Google Maps**: Θα πρέπει να αποκτήσετε ένα καινούργιο API_KEY καθώς το SHA1 fingerprint της εφαρμογής έχει αλλάξει. Από τη σελίδα [Google Developers Console](https://console.developers.google.com/cloud-resource-manager) πατήστε το κουμπί *Create Project*, δώστε ένα όνομα π.χ. Peersonmap και πατήστε το κουμπί *Create*. Στη συνέχεια επιλέξετε *APIs & services* και στο Library πατήστε Enable για κάθε ένα ένα από τα ακόλουθα APIs:

 - Google Maps Android API
 - Google Maps Direction API
 - Google Maps JavaScript API
 - Google Maps Roads API 
 
 επίσης από το *Credentials* στο *APIs & services* πατήστε το κουμπί *Create credentials-->API key*. Στα restrictions του API key που δημιουργήθηκε επιλέγετε Android apps για να εισάγετε το package name, το νέο SHA1 fingerprint της εφαρμογής και πατήστε Save. Αντιγράψτε το νέο API Key π.χ. AIzaSyBIzq2BMBbDvBqjDE0YYSQcCo5Wi5dmtVA και καταχωρήστε στο \app\src\main\res\values\google_maps_api.xml και στα \app\src\main\res\values\strings.xml και \app\src\main\res\values-el\strings.xml.
 Βεβαιωθείτε ότι στο αρχείο AndroidManifest.xml υπάρχει η καταχώρηση:
> < meta-data
>    android:name="com.google.android.geo.API_KEY"
>    android:value="@string/google_maps_key" />

 7. **Δημιουργία Google Play Game**: Από το [Google Play Developer Console](https://play.google.com/apps/publish) επιλέξτε *Υπηρεσίες παιχνιδιών* και πατήστε το κουμπί *Προσθήκη νέου παιχνιδιού*. Από το σημείο αυτό έχετε τη δυνατότητα να εισάγεται όλα τα στοιχεία του παιχνιδιού που θα συνδεθεί με την εφαρμογή και συγκεκριμένα να δημιουργήσετε τον *Πίνακα κατάταξης* των παικτών και τα διαθέσιμα *Επιτεύγματα*. <br/>
 Για τον πίνακα κατάταξης των παικτών, επιλέξτε το όνομα και την εικόνα που θα εμφανίζεται, ενώ στη μορφοποίηση βαθμολογίας επιλέξτε αριθμητικό τύπο και 0 δεκαδικά ψηφία. <br/>
 Για το κάθε επίτευγμα πρέπει να εισάγετε το όνομα, την περιγραφή, το εικονίδιό, τα βήματα που απαιτούνται για να ξεκλειδώσει, την αρχική του κατάσταση (αποκαλύφθηκε ή κρυφό), τον αριθμό των πόντων που θα λαμβάνει ο παίκτης και τέλος τη θέση του στη λίστα. Τα επιτεύγματα που υλοποιούνται στο project είναι τα ακόλουθα: <br/>
 
 - Ανέβασες 10 μονοπάτια (5 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 25 μονοπάτια (20 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 50 μονοπάτια (35 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 75 μονοπάτια (40 πόντοι - κρυφό)
 - Ανέβασες 100 μονοπάτια (100 πόντοι - κρυφό)
 - Ανέβασες 10 νέα μονοπάτια (10 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 25 νέα μονοπάτια (40 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 50 νέα μονοπάτια (50 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 75 νέα μονοπάτια (80 πόντοι - κρυφό)
 - Ανέβασες 100 νέα μονοπάτια (120 πόντοι - κρυφό)
 - Ανέβασες 25 χλμ. μονοπατιών (25 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 50 χλμ. μονοπατιών (50 πόντοι - αποκαλύφθηκε)
 - Ανέβασες 75 χλμ. μονοπατιών (75 πόντοι - κρυφό)
 - Ανέβασες 100 χλμ. μονοπατιών (100 πόντοι - κρυφό)
 - Σχολίασες 10 μονοπάτια (20 πόντοι - αποκαλύφθηκε)
 - Σχολίασες 25 μονοπάτια (40 πόντοι - αποκαλύφθηκε)
 - Σχολίασες 50 μονοπάτια (60 πόντοι - κρυφό)
 - Σχολίασες 100 μονοπάτια (120 πόντοι - κρυφό)
  
Στην καρτέλα *Δοκιμή* μπορούν να καθοριστούν οι υπεύθυνοι δοκιμής του παιχνιδιού, πρίν την ενεργοποίησή του μέσα από την καρτέλα *Δημοσίευση*. <br/>
Το μοναδικό αναγνωριστικό του παιχνιδιού, τα αναγνωριστικά του πίνακα και των επιτευγμάτων πρέπει να καταχωρηθούν στις αντίστοιχες μεταβλητές του Android project στο αρχείο \app\src\main\res\values\ids.xml.
Βεβαιωθείτε ότι στο αρχείο AndroidManifest.xml υπάρχουν οι καταχωρήσεις:

> < meta-data
>	android:name="com.google.android.gms.games.APP_ID"
>	android:value="@string/app_id" />
> < meta-data
>	android:name="com.google.android.gms.version"
>	android:value="@integer/google_play_services_version" />

 8. Στην κλάση PomApplication (μεταβλητή serverUrl) μπορείτε να ορίσετε τη διεύθυνση που τρέχει ο server του συστήματος και στην οποία θα γίνονται οι κλήσεις από την εφαρμογή.
 9. **Ενσωμάτωση Analytics**: Στη σελίδα [Firebase Console](https://console.firebase.google.com/) πατήστε το κουμπί *Import Google Project*, επιλέξτε το project που έχετε δημιουργήσει, τη χώρα και πατήστε το κουμπί *Add Firebase*. Στη συνέχεια από την κεντρική οθόνη του Firebase επιλέγετε *Settings--->General-->Add Firebase to your Android app*, προσθέτετε τα στοιχεία της εφαρμογής που δημιουργήσατε και κατεβάστε το αρχείο google-services.json το οποίο αποθηκεύετε στο φάκελο \app\ της εφαρμογής. Επίσης, πρέπει να αντικατασταθεί στην κλάση PomApllication στην Tracker το νέο tracking_id των analytics που φαίνεται στο google-services.json:
> "services": {
>        "analytics_service": {
>          "status": 2,
>          "analytics_property": {
>            "tracking_id": "UA-87764347-1"
>          }
>        }

 10. **Εγκατάσταση της εφαρμογής σε κινητή συσκευή Android**: Από το μενού της συσκευής επιλέξτε τις επιλογές *Ρυθμίσεις-->Επιλογές προγραμματιστή-->Εντοπισμός σφαλμάτων USB* και *Ρυθμίσεις-->Ασφάλεια-->Άγνωστες πηγές*. Στη συνέχεια συνδέστε το κινητό σας τηλέφωνο με τον υπολογιστή με καλώδιο USB. Στο Android Studio επιλέξτε από το μενού *Run-->Run 'app'* και στο παράθυρο που εμφανίζεται επιλέξτε τη συσκευή σας και πατήστε το κουμπί *OK*.
 
