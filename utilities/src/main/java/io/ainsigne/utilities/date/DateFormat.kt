package io.ainsigne.utilities.date

/**
 * Known bug! Do not use YYYY but yyyy if not needed:
 * see https://www.juandebravo.com/2015/04/10/java-yyyy-date-format/
 */
enum class DateFormat(val pattern: String) {
    DD_MMM_YYYY_HH_MM("dd MMM yyyy HH:mm"),
    DD_MMM_YYYY("dd MMM yyyy"),
    DD_MMMM_SEPARATOR_YYYY("dd MMMM, yyyy"),
    MMM_DD_YYYY("MMM dd yyyy"),
    YYYY_MM_DD("yyyy-MM-dd"),
    ISO_8601("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    EEEEE("EEEEE"),
    EEE("EEE"),
    MMMM("MMMM")
}