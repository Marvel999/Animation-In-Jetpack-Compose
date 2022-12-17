package com.wrapx.imajzo

object Data {
    fun getListItem():List<ListItemData> = listOf(
        ListItemData(animationName = R.string.animated_visibility, animationType = AnimationType.ANIMATE_VISIBILITY),
        ListItemData(animationName = R.string.animate_as_state, animationType = AnimationType.ANIMATE_AS_STATE),
        ListItemData(animationName = R.string.animate_content, animationType = AnimationType.ANIMATE_CONTENT),
        ListItemData(animationName = R.string.animate_Content_size, animationType = AnimationType.ANIMATE_CONTENT_SIZE),
        ListItemData(animationName = R.string.cross_fade, animationType = AnimationType.CROSS_FADE),
        ListItemData(animationName = R.string.update_transition, animationType = AnimationType.UPDATE_TRANSITION),
        ListItemData(animationName = R.string.remember_infinite_transition, animationType = AnimationType.REMEMBER_INFINITE_TRANSITION),
    )
}

data class ListItemData(val animationType: AnimationType, val animationName: Int)

enum class AnimationType {
    ANIMATE_VISIBILITY,
    ANIMATE_CONTENT,
    ANIMATE_AS_STATE,
    ANIMATE_CONTENT_SIZE,
    CROSS_FADE,
    REMEMBER_INFINITE_TRANSITION,
    UPDATE_TRANSITION
}