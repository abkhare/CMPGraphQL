package com.khareab.cmp.graphql.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khareab.cmp.graphql.domain.GetCountriesUseCase
import com.khareab.cmp.graphql.domain.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    val getCountryUseCase: GetCountryUseCase,
    val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dismissDialog() {
        _state.update {
            it.copy(selectedCountry = null)
        }
    }

}