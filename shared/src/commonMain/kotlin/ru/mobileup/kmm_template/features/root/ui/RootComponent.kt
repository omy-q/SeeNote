package ru.mobileup.kmm_template.features.root.ui

import ru.mobileup.kmm_template.core.message.ui.MessageComponent

/**
 * A root of a Decompose component tree.
 *
 * Note: Try to minimize child count in RootComponent. It should operate by flows of screens rather than separate screens.
 */
interface RootComponent {

    val messageComponent: MessageComponent
}