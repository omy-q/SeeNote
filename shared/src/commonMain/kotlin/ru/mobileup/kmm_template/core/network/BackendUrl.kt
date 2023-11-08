package ru.mobileup.kmm_template.core.network

import ru.mobileup.kmm_template.core.configuration.Backend
import kotlin.jvm.JvmInline

@JvmInline
value class BackendUrl(val value: String) {

    companion object {
        private val MainDevelopmentUrl = BackendUrl("")
        private val MainProductionUrl = BackendUrl("")

        fun getMainUrl(backend: Backend) = when (backend) {
            Backend.Development -> MainDevelopmentUrl
            Backend.Production -> MainProductionUrl
        }
    }
}