package com.optic.challengemeli.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.optic.challengemeli.data.model.SuggestionQuery;
import com.optic.challengemeli.data.repository.SuggestionsRepository;

public class SuggestionsViewModel extends ViewModel {

    private SuggestionsRepository suggestionsRepository;
    private LiveData<SuggestionQuery> suggestionsLiveData;

    public SuggestionsViewModel() {
        suggestionsRepository = new SuggestionsRepository();
    }

    /*
     * ESTABLESCO LA INFORMACIONDE LA BUSQUEDA EN EL OBSERVABLE LIVE DATA
     * @param searchText -> Texto de busqueda
     */
    public void setSuggestionsLiveData(String searchText) {
        suggestionsLiveData = suggestionsRepository.getSearchSuggestions(searchText);
    }

    /*
     * RETORNO EL OBSERVABLE CON LA LISTA DE SUGERENCIAS
     */
    public LiveData<SuggestionQuery> getSuggestionsLiveData() {
        return suggestionsLiveData;
    }

}
