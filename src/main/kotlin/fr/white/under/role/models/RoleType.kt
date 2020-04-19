package fr.white.under.role.models


enum class RoleType {

    CIVIL {
        override fun hasWon(roles: MutableList<Role>): Boolean {
            var alive = roles.filter { r -> r.alive }
            return !alive.map { r -> r.roleType }.contains(RoleType.UNDERCOVER) && !alive.map { r -> r.roleType }.contains(RoleType.MISTERWHITE)

        }
    },

    MISTERWHITE {
        override fun hasWon(roles: MutableList<Role>): Boolean {
            return false
        }
    },

    UNDERCOVER {
        override fun hasWon(roles: MutableList<Role>): Boolean {
            var alive = roles.filter { r -> r.alive }
            return alive.map { r -> r.roleType }.filter { r -> r.equals(CIVIL) }.count() <= 1

        }
    },

    NONE {
        override fun hasWon(roles: MutableList<Role>): Boolean {
            return false;
        }
    };

    abstract fun hasWon(roles: MutableList<Role>): Boolean


    //Static Section
    companion object {
        fun getDefaultRolesTypes(playerAmount: Int): MutableList<RoleType> {
            val roles = mutableListOf(CIVIL, CIVIL, UNDERCOVER, CIVIL, MISTERWHITE, CIVIL, UNDERCOVER, CIVIL, UNDERCOVER, CIVIL, MISTERWHITE, CIVIL)
            return roles.subList(0, playerAmount);
        }
    }
}
