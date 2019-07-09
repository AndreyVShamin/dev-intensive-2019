package ru.skillbranch.devintensive.extentions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.utils


fun User.toUserView() : UserView {
    val nickName = utils.transliteration("$firstName $lastName")
    val initials = utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще ни разу не был" else if (isOnline) "online"
                    else "Последний раз был ${lastVisit}"
    //               else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status)
}


