package in.indiaonline.news.mvpsupriyafirst;

public class PresenterImpl implements MainContract.Presenter,MainContract.GetQuoteInteractor.onFinishedListener{

    private MainContract.MainView mainView;

    public PresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    private MainContract.GetQuoteInteractor getQuoteInteractor;

    @Override
    public void onButtonClick() {
        if(mainView!=null){
            mainView.showProgress();
            getQuoteInteractor.getNextQuote(this);
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(String str) {
        if(mainView!=null){
            mainView.hideProgress();
            mainView.setQuote(str);

        }
    }
}
