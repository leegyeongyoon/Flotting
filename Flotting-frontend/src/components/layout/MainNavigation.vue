<template>
    <v-navigation-drawer :elevation="3" class="blue-grey-darken-2" v-if="drawer" v-model="selectedItem">
<!--        <v-list>-->
<!--            <v-list-item>-->
<!--                <v-list-item-avatar> 아이콘</v-list-item-avatar>-->
<!--            </v-list-item>-->
<!--            <v-list-item link>-->
<!--                <v-list-item-content>-->
<!--                    <v-list-item-title class="text-h6">-->
<!--                        Flooting-->
<!--                    </v-list-item-title>-->
<!--                    <v-list-item-subtitle>https://flotting.com/</v-list-item-subtitle>-->
<!--                </v-list-item-content>-->
<!--                <v-list-item-action>-->
<!--                    <v-icon>mdi-menu-down</v-icon>-->
<!--                </v-list-item-action>-->
<!--            </v-list-item>-->
<!--        </v-list>-->
<!--        <v-divider></v-divider>-->
        <v-list v-model:opened="open">
          <v-list-item :to="'/'" prepend-icon="mdi-view-dashboard" title="대시 보드" value="dashboard"></v-list-item>
          <v-list-item :to="'/account'" prepend-icon="mdi-view-dashboard" title="Account" value="account"></v-list-item>
          <v-list-group value="ExistingManagement">
            <template v-slot:activator="{ props }">
              <v-list-item
                  v-bind="props"
                  prepend-icon="mdi-account-circle"
                  title="기존 고객"
              ></v-list-item>
            </template>
            <v-list-item
                v-for="([title, to], i) in existingManagement"
                :key="i"
                :title="title"
                :value="title"
                :to="to"
            ></v-list-item>
          </v-list-group>
          <v-list-group value="NewManagement">
            <template v-slot:activator="{ props }">
              <v-list-item
                  v-bind="props"
                  prepend-icon="mdi-account-circle-outline"
                  title="신규 고객"
              ></v-list-item>
            </template>
            <v-list-item
                v-for="([title, to], i) in newManagement"
                :key="i"
                :title="title"
                :value="title"
                :to="to"
            ></v-list-item>
          </v-list-group>
          <v-list-group value="ExistingConsulting">
            <template v-slot:activator="{ props }">
              <v-list-item
                  v-bind="props"
                  prepend-icon="mdi-lan"
                  title="고객 상담"
              ></v-list-item>
            </template>
            <v-list-item
                v-for="([title, to], i) in existingConsulting"
                :key="i"
                :title="title"
                :value="title"
                :to="to"
            ></v-list-item>
          </v-list-group>
          <v-list-group value="Announcement">
            <template v-slot:activator="{ props }">
              <v-list-item
                  v-bind="props"
                  prepend-icon="mdi-bell-circle"
                  title="공지 사항"
              ></v-list-item>
            </template>
            <v-list-item
                v-for="([title, to], i) in announcement"
                :key="i"
                :title="title"
                :value="title"
                :to="to"
            ></v-list-item>
          </v-list-group>
          <v-list-item :to="'/indicator'" prepend-icon="mdi-chart-line" title="지표 관리(기존)" value="indicator"></v-list-item>
        </v-list>
        <template v-slot:append>
            <div class="pa-2">
                <v-btn block>
                    Logout
                </v-btn>
            </div>
        </template>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: "MainNavigation",
    props: {
        drawer: {
            type: Boolean,
            required: true
        },
    },
    data() {
        return {
          open: [''],
          existingManagement: [
              ['고객 정보 검색', '/mng/user'],
              ['프로필 변경 요청', '/mng/profile']
          ],
          newManagement: [
            ['1차 등록 고객', '/reg/first'],
            ['2차 등록 고객', '/reg/second']
          ],
          existingConsulting: [
            ['고객 CS 응대', '/cns/user'],
            ['매니저 전담 소개', '/cns/manager']
          ],
          announcement: [
            ['관리자 공지사항', '/noti/admin'],
            ['고객 공지사항', '/noti/user']
          ],
          selectedItem: null
        };
    }
};
</script>

<style scoped></style>
