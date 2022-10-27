# Compose likeButton

Compose like button.

## How to Use

```kotlin
@Composeable
fun Content() {
    LikeButton(
        size = 50.dp,
        likeButtonState = rememberLikeButtonState(
            initIsLiked = false,
        ),
    )
}
```

## Thx

Flutter [like_button](https://github.com/fluttercandies/like_button)
