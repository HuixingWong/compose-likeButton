# Compose likeButton

Compose like button.




https://user-images.githubusercontent.com/15938606/199025643-64477ba5-eec3-4587-88f3-cddd3f8378be.mov



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
