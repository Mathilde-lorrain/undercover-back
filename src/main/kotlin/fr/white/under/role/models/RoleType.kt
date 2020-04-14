package fr.white.under.role.models

enum class RoleType {

    CIVIL {
        override fun hasWon(): Boolean {
            TODO("Not yet implemented")
        }
    },

    MISTERWHITE {
        override fun hasWon(): Boolean {
            TODO("Not yet implemented")
        }
    },

    UNDERCOVER {
        override fun hasWon(): Boolean {
            TODO("Not yet implemented")
        }
    },

    NONE {
        override fun hasWon(): Boolean {
            return false;
        }
    };

    abstract fun hasWon(): Boolean


    //Static Section
    companion object {
        fun getDefaultRolesTypes(playerAmount: Int): MutableList<RoleType> {
            val roles = mutableListOf(CIVIL, CIVIL, UNDERCOVER, CIVIL, MISTERWHITE, CIVIL, UNDERCOVER, CIVIL, UNDERCOVER, CIVIL, MISTERWHITE, CIVIL)
            return roles.subList(0, playerAmount);
        }
    }
}