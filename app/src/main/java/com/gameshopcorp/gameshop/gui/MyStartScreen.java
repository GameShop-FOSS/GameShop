package com.gameshopcorp.gameshop.gui;
import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;
import static android.content.Intent.parseUri;

//import static com.jme3.app.state.ConstantVerifierState.ErrorType.Log;

//import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.gameshopcorp.gameshop.MainActivity;
import com.gameshopcorp.gameshop.R;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.installations.FirebaseInstallations;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.system.JmeSystem;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.Executor;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class MyStartScreen extends BaseAppState implements ScreenController {

    FirebaseFirestore db;

    Element keyboardLayer;
    String firebaseID;
    private static final String TAG = "EmailPassword";
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    Nifty nifty;
    Application app;
    public void gotoScreen(String nextScreen){

        nifty.gotoScreen(nextScreen);
    }
    @Override
    public void initialize(Application app) {
        //It is technically safe to do all initialization and cleanup in the
        //onEnable()/onDisable() methods. Choosing to use initialize() and
        //cleanup() for this is a matter of performance specifics for the
        //implementor.
        //TODO: initialize your AppState, e.g. attach spatials to rootNode
        // Access a Cloud Firestore instance from your Activity

        this.app = app;
        //signInWithFireBase();

        // [START initialize_auth]
        // Initialize Firebase Auth
      //  mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        //createAccount("gameshopcorp@mgmail.com", "Password");


//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            // User is signed in
//            System.out.println("USER SIGNED IN " + user.getDisplayName() + " " + user.getEmail());
//
//        } else {
//            // No user is signed in
//
//            System.out.println("USER NOT SIGNED IN");
//        }


         db = FirebaseFirestore.getInstance();


        FirebaseInstallations.getInstance().getId()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (task.isSuccessful()) {
                            Log.d("Installations", "Installation ID: " + task.getResult());
                            firebaseID = task.getResult();
                        } else {
                            Log.e("Installations", "Unable to get Installation ID");
                        }
                    }
                });





    }


    public void signup(){

    }

    public void login(){

    }

    public void keyboard(){

//        String sequence = "";
//
//        InputMethodManager im = (InputMethodManager)MainActivity.self.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        im.showSoftInput(MainActivity.self.findViewById(R.id.jMEFragment), InputMethodManager.SHOW_FORCED);

        this.keyboardLayer.show();


    }
    public void gotosignupscreen(){
        nifty.gotoScreen("signup");
    }

    public void gotologinscreen(){
        nifty.gotoScreen("login");
    }
//    private void createAccount(String email, String password) {
//        // [START create_user_with_email]
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(MainActivity.self, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(MainActivity.self, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//        // [END create_user_with_email]
//    }

//    private void signIn(String email, String password) {
//        // [START sign_in_with_email]
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener((Executor) MainActivity.self, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(MainActivity.self, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//        // [END sign_in_with_email]
//    }

//    private void sendEmailVerification() {
//        // Send verification email
//        // [START send_email_verification]
//        final FirebaseUser user = mAuth.getCurrentUser();
//        user.sendEmailVerification()
//                .addOnCompleteListener((Executor) MainActivity.self, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // Email sent
//                    }
//                });
//        // [END send_email_verification]
//    }

    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }


    @Override
    protected void cleanup(Application app) {
        //TODO: clean up what you initialized in the initialize method,
        //e.g. remove all spatials from rootNode
    }

    //onEnable()/onDisable() can be used for managing things that should
    //only exist while the state is enabled. Prime examples would be scene
    //graph attachment or input listener attachment.
    @Override
    protected void onEnable() {
        //Called when the state is fully enabled, ie: is attached and
        //isEnabled() is true or when the setEnabled() status changes after the
        //state is attached.
    }

    @Override
    protected void onDisable() {
        //Called when the state was previously enabled but is now disabled
        //either because setEnabled(false) was called or the state is being
        //cleaned up.
    }

    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        Intent intent = null;
//        try {
//            intent = parseUri("com.gameshopcorp.gameshop", 0);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        String emailLink = Objects.requireNonNull(intent.getData()).toString();
//
//// Confirm the link is a sign-in with email link.
//        if (auth.isSignInWithEmailLink(emailLink)) {
//            // Retrieve this from wherever you stored it
//            String email = "gameshopcorp@gmail.com";
//
//            // The client SDK will parse the code from the link for you.
//            auth.signInWithEmailLink(email, emailLink)
//                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                Log.d(TAG, "Successfully signed in with email link!");
//                                AuthResult result = task.getResult();
//                                // You can access the new user via result.getUser()
//                                // Additional user info profile *not* available via:
//                                // result.getAdditionalUserInfo().getProfile() == null
//                                // You can check if the user is new or existing:
//                                // result.getAdditionalUserInfo().isNewUser()
//                            } else {
//                                Log.e(TAG, "Error signing in with email link", task.getException());
//                            }
//                        }
//                    });
//        }
    }

    /**
     * Bind this ScreenController to a screen. This happens right before the
     * onStartScreen STARTED and only exactly once for a screen!
     * @param nifty nifty
     * @param screen screen
     */
    @Override
    public void bind(Nifty nifty, Screen screen) {
       // throw new UnsupportedOperationException("Not supported yet.");

        this.nifty = nifty;
        if (screen.getScreenId().equals("signup")) {
            this.keyboardLayer = screen.findElementById("keyboard");

            this.keyboardLayer.hide();
        }
    }

    /**
     * called right after the onStartScreen event ENDED.
     */
    @Override
    public void onStartScreen() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * called right after the onEndScreen event ENDED.
     */
    @Override
    public void onEndScreen() {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void gotoGoogleSignIn(){
        System.out.println("Hi");
        nifty.gotoScreen("googlesignin");
    }

//    public void verifyEmail(){
//
//        ActionCodeSettings actionCodeSettings =
//                ActionCodeSettings.newBuilder()
//                        // URL you want to redirect back to. The domain (www.example.com) for this
//                        // URL must be whitelisted in the Firebase Console.
//                        .setUrl("https://www.google.com")
//                        // This must be true
//                        .setHandleCodeInApp(true)
//                        //.setIOSBundleId("com.example.ios")
//                        .setAndroidPackageName(
//                                "com.gameshopcorp.gameshop",
//                                true, /* installIfNotAvailable */
//                                "12"    /* minimumVersion */)
//                        .build();
//
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        Task<Void> voidTask = auth.sendSignInLinkToEmail("gameshopcorp@gmail.com", actionCodeSettings)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "Email sent.");
//                        }
//                    }
//                });
//    }

//    public void signInWithFireBase(){
//       BeginSignInRequest signInRequest = BeginSignInRequest.builder()
//                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                        .setSupported(true)
//                        // Your server's client ID, not your Android client ID.
//                        .setServerClientId("gameshop-b5813")
//                        // Only show accounts previously used to sign in.
//                        .setFilterByAuthorizedAccounts(true)
//                        .build())
//                .build();
//    }

}
