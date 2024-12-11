<template>

    <v-card outlined>
        <v-card-title>
            Requester
        </v-card-title>

        <v-card-text>
            <String label="name" v-model="value.Name" :editMode="editMode"/>
            <String label="department" v-model="value.Department" :editMode="editMode"/>
            <String label="employeeNumber" v-model="value.EmployeeNumber" :editMode="editMode"/>
            <String label="phoneNumber" v-model="value.PhoneNumber" :editMode="editMode"/>
            <String label="mobileNumber" v-model="value.MobileNumber" :editMode="editMode"/>
            <Date label="requestDate" v-model="value.RequestDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'Requester',
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
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'Name': '',
                    'Department': '',
                    'EmployeeNumber': '',
                    'PhoneNumber': '',
                    'MobileNumber': '',
                    'RequestDate': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('Name' in this.value)) {
                    this.value.Name = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Department' in this.value)) {
                    this.value.Department = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('EmployeeNumber' in this.value)) {
                    this.value.EmployeeNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('PhoneNumber' in this.value)) {
                    this.value.PhoneNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('MobileNumber' in this.value)) {
                    this.value.MobileNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('RequestDate' in this.value)) {
                    this.value.RequestDate = '2024-12-11';
                }
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
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

