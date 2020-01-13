package in.indiaonline.news.mvpsupriyafirst.FirstApp;

public class MainContract {

    interface GetQuoteInteractor{

        interface onFinishedListener{
            void onFinished(String str);
        }

        void getNextQuote(onFinishedListener onFinishedListener);
    }

    interface MainView{
         void showProgress();
         void hideProgress();
         void setQuote(String str);

    }

    interface Presenter{

        void onButtonClick();
        void onDestroy();
    }


}
