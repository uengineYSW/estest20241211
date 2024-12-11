<template>

    <v-card outlined>
        <v-card-title>
            ApprovalInfo
        </v-card-title>

        <v-card-text>
            <String label="approverName" v-model="value.ApproverName" :editMode="editMode"/>
            <String label="approverPosition" v-model="value.ApproverPosition" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'ApprovalInfo',
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
                    'ApproverName': '',
                    'ApproverPosition': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('ApproverName' in this.value)) {
                    this.value.ApproverName = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('ApproverPosition' in this.value)) {
                    this.value.ApproverPosition = '';
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

