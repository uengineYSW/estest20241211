<template>
    <v-card outlined>
        <v-card-title>
            UpdateDispatchStatus
        </v-card-title>

        <v-card-text>
            <Number label="DispatchStatusId" v-model="value.dispatchStatusId" :editMode="editMode"/>
            <String label="ProgressStage" v-model="value.progressStage" :editMode="editMode"/>
            <Date label="ApprovalDate" v-model="value.approvalDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateDispatchStatus"
            >
                UpdateDispatchStatus
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
        name: 'UpdateDispatchStatusCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.dispatchStatusId = 0;
            this.value.progressStage = '';
            this.value.approvalDate = '2024-12-11';
        },
        watch: {
        },
        methods: {
            updateDispatchStatus() {
                this.$emit('updateDispatchStatus', this.value);
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

