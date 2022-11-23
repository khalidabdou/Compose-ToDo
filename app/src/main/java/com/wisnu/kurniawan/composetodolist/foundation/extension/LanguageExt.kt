package com.wisnu.kurniawan.composetodolist.foundation.extension

import com.wisnu.kurniawan.composetodolist.features.localized.setting.ui.LanguageItem
import com.wisnu.kurniawan.composetodolist.foundation.datasource.preference.model.LanguagePreference
import com.wisnu.kurniawan.composetodolist.model.Language

fun Language.toLanguagePreference(): LanguagePreference {
    return when (this) {
        Language.ENGLISH -> LanguagePreference.ENGLISH
        Language.INDONESIA -> LanguagePreference.INDONESIA
        Language.ARABIC -> LanguagePreference.ARABIC
    }
}

fun LanguagePreference.toLanguage(): Language {
    return when (this) {
        LanguagePreference.ENGLISH -> Language.ENGLISH
        LanguagePreference.INDONESIA -> Language.INDONESIA
        LanguagePreference.ARABIC -> Language.ARABIC
    }
}

fun List<LanguageItem>.select(language: Language): List<LanguageItem> {
    return map {
        it.copy(applied = it.language == language)
    }
}
