<template>

    <v-card outlined>
        <v-card-title>
            DispatchRequestReference
        </v-card-title>

        <v-card-text>
            <Requester offline label="requester" v-model="value.Requester" :editMode="editMode" @change="change"/>
            <DispatchPeriod offline label="dispatchPeriod" v-model="value.DispatchPeriod" :editMode="editMode" @change="change"/>
            <DispatchPurpose offline label="dispatchPurpose" v-model="value.DispatchPurpose" :editMode="editMode" @change="change"/>
            <VehicleType offline label="vehicleType" v-model="value.VehicleType" :editMode="editMode" @change="change"/>
            <Number label="numberOfPassengers" v-model="value.NumberOfPassengers" :editMode="editMode"/>
            <Boolean label="driverIncluded" v-model="value.DriverIncluded" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'DispatchRequestReference',
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
                    'Requester': '',
                    'DispatchPeriod': '',
                    'DispatchPurpose': '',
                    'VehicleType': '',
                    'NumberOfPassengers': '',
                    'DriverIncluded': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('NumberOfPassengers' in this.value)) {
                    this.value.NumberOfPassengers = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('DriverIncluded' in this.value)) {
                    this.value.DriverIncluded = false;
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

