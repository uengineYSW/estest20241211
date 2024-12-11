<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title>
            Department
        </v-card-title>
        <v-card-text>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="departmentList"
                ></v-select>
            </div>
            <div v-else style="margin-top:-20px;">
                Department : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'Department',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            departmentList : [ "서울(포스코센터)",  "포항제철소",  "광양제철소", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.departmentList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>

