<template>
    <v-card outlined>
        <v-card-title>
            CancelDispatchRequest
        </v-card-title>

        <v-card-text>
            <Number label="DispatchRequestId" v-model="value.dispatchRequestId" :editMode="editMode"/>
            <String label="CancellationReason" v-model="value.cancellationReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="cancelDispatchRequest"
            >
                CancelDispatchRequest
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
        name: 'CancelDispatchRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.dispatchRequestId = 0;
            this.value.cancellationReason = '';
        },
        watch: {
        },
        methods: {
            cancelDispatchRequest() {
                this.$emit('cancelDispatchRequest', this.value);
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

