package com.jmyebenes.curriculum.domain.model

enum class ContactType {
    TEL,
    MAIL,
    LINK,
    UNKNOWN;

    companion object {
        fun fromString(string: String): ContactType {
            return when (string) {
                PHONE_STRING -> TEL
                MAIL_STRING -> MAIL
                LINK_STRING -> LINK
                else -> UNKNOWN
            }
        }

        fun ContactType.toStringValue(): String {
            return when (this) {
                TEL -> PHONE_STRING
                MAIL -> MAIL_STRING
                LINK -> LINK_STRING
                UNKNOWN -> UNKNOWN_STRING
            }
        }
    }
}

private const val PHONE_STRING = "phone"
private const val MAIL_STRING = "mail"
private const val LINK_STRING = "link"
private const val UNKNOWN_STRING = "unknown"