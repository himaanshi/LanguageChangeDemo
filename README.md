# LanguageChangeDemo
Demo shows how to change language at run time . In this demo I have 3 languages  Hindi, english, French. 

@Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }
