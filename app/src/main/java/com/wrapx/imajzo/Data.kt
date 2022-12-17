package com.wrapx.imajzo

object Data {
    fun getListItem():List<ListItemData> = listOf(
        ListItemData(animationName = "AnimateVisibility", animationType = AnimationType.ANIMATE_VISIBILITY),
        ListItemData(animationName = "AnimateContent", animationType = AnimationType.ANIMATE_CONTENT),
        ListItemData(animationName = "Animation3", animationType = AnimationType.ANIMATION3),
        ListItemData(animationName = "Animation4", animationType = AnimationType.ANIMATION4),
        ListItemData(animationName = "Animation5", animationType = AnimationType.ANIMATION5)
    )
}

data class ListItemData(val animationType: AnimationType, val animationName: String)

enum class AnimationType {
    ANIMATE_VISIBILITY,
    ANIMATE_CONTENT,
    ANIMATION3,
    ANIMATION4,
    ANIMATION5,
    ANIMATION6
}