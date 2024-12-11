<template>
    <v-card outlined>
        <v-card-title>
            UpdateDispatchRequest
        </v-card-title>

        <v-card-text>
            <Number label="DispatchRequestId" v-model="value.dispatchRequestId" :editMode="editMode"/>
            <DispatchPurpose offline label="DispatchPurpose" v-model="value.dispatchPurpose" :editMode="editMode" @change="change"/>
            <DispatchPeriod offline label="DispatchPeriod" v-model="value.dispatchPeriod" :editMode="editMode" @change="change"/>
            <VehicleType offline label="VehicleType" v-model="value.vehicleType" :editMode="editMode" @change="change"/>
            <Number label="NumberOfPassengers" v-model="value.numberOfPassengers" :editMode="editMode"/>
            <Boolean label="DriverIncluded" v-model="value.driverIncluded" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <String label="ContactNumber" v-model="value.contactNumber" :editMode="editMode"/>
            <File offline label="Attachment" v-model="value.attachment" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateDispatchRequest"
            >
                UpdateDispatchRequest
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateDispatchRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.dispatchRequestId = 0;
            this.value.dispatchPurpose = {};
            this.value.dispatchPeriod = {};
            this.value.vehicleType = {};
            this.value.numberOfPassengers = 0;
            this.value.driverIncluded = false;
            this.value.remarks = '';
            this.value.contactNumber = '';
            this.value.attachment = {};
        },
        watch: {
        },
        methods: {
            updateDispatchRequest() {
                this.$emit('updateDispatchRequest', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

