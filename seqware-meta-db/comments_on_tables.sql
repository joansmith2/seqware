comment on table expense 			  is 'Auxiliary table for tracking expenses (not used at OICR)';
comment on table expense_attribute 		  is 'Auxiliary table for attributing expenses (not used at OICR)';
comment on table experiment 			  is 'High-level organization of samples (required, used for reporting, created by migration)';
comment on table experiment_attribute 		  is 'Attributes for experiments, created by the attribute annotator';
comment on table experiment_library_design        is 'Tracks experiment library design for reporting';
comment on table experiment_link                  is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table experiment_spot_design           is 'Tracks experiment spot design for reporting';
comment on table experiment_spot_design_read_spec is 'Tracks experiment spot design read specifications for reporting';
comment on table file                             is 'Track files used as input for and output from workflow runs (required, created by SeqWare)';
comment on table file_attribute                   is 'Attributes for files, created by the attribute annotator';
comment on table file_provenance_report           is 'Generated table (essentially a materialized view, generated by SeqWare)';
comment on table file_report                      is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table file_type                        is 'Track meta-types for files (used by deciders)';
comment on table invoice                          is 'Track costs for workflows (unused at OICR)';
comment on table invoice_attribute                is 'Attributes for invoices';
comment on table ius                              is 'Indivisible unit of sequencing (used for reporting, created by migration)';
comment on table ius_attribute                    is 'Attributes for ius(es), created by the attribute annotator';
comment on table ius_link                         is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table ius_workflow_runs                is 'Deprecated table used to associate ius with workflow runs';
comment on table lane                             is 'High-level organization of IUS, an actual lane on a sequencer (used for reporting, created by migration)';
comment on table lane_attribute                   is 'Attributes for lanes, created by the attribute annotator';
comment on table lane_link                        is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table lane_type                        is 'Tracks lane type for reporting';
comment on table lane_workflow_runs               is 'Deprecated table used to associate lanes with workflow runs';
comment on table library_selection                is 'Documents libraries for experiments';
comment on table library_source                   is 'Documents libraries for experiments';
comment on table library_strategy                 is 'Documents libraries for experiments';
comment on table organism                         is 'Track organisms for samples and lanes';
comment on table platform                         is 'Documents platforms for experiments';
comment on table processing                       is 'Record details for steps of a workflow_run (created by SeqWare)';
comment on table processing_attribute             is 'Attributes for processing events';
comment on table processing_experiments           is 'Relates steps of a workflow to high-level metadata';
comment on table processing_files                 is 'Relates steps of a workflow to high-level metadata';
comment on table processing_ius                   is 'Relates steps of a workflow to high-level metadata';
comment on table processing_lanes                 is 'Relates steps of a workflow to high-level metadata';
comment on table processing_relationship          is 'Relates steps of a workflow to high-level metadata';
comment on table processing_samples               is 'Relates steps of a workflow to high-level metadata';
comment on table processing_sequencer_runs        is 'Relates steps of a workflow to high-level metadata';
comment on table processing_studies               is 'Relates steps of a workflow to high-level metadata';
comment on table registration                     is 'Authenticate users of this metadb';
comment on table sample                           is 'High-level organization of IUS (used for reporting, created by migration)';
comment on table sample_attribute                 is 'Attributes for samples, created by the attribute annotator';
comment on table sample_hierarchy                 is 'Relationship of samples as they pass through the wet lab (created by migration)';
comment on table sample_link                      is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table sample_relationship              is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table sample_report                    is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table sample_search                    is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table sample_search_attribute          is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table sequencer_run                    is 'High-level organization of lanes, an actual run of a sequencer (used for reporting, created by migration)';
comment on table sequencer_run_attribute          is 'Attributes for sequencer runs, created by the attribute annotator';
comment on table share_experiment                 is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_file                       is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_lane                       is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_processing                 is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_sample                     is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_study                      is 'Support for the SeqWare portal (unused at oicr)';
comment on table share_workflow_run               is 'Support for the SeqWare portal (unused at oicr)';
comment on table study                            is 'High-level organization of experiments (required for reporting, created by migration)';
comment on table study_attribute                  is 'Attributes for studies, created by the attribute annotator';
comment on table study_link                       is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table study_type                       is 'Documents studies';
comment on table version                          is 'Legacy table inspired by SRA schema (unused at OICR)';
comment on table workflow                         is 'Records installed workflows (created by SeqWare)';
comment on table workflow_attribute               is 'Attributes for workflows, created by the attribute annotator';
comment on table workflow_param                   is 'Records parameters for workflows (populates default workflow.ini)';
comment on table workflow_param_value             is 'Records default parameter values for workflows (populates default workflow.ini)';
comment on table workflow_run                     is 'Tracks runs of installed workflows (used by reporting, created by SeqWare)';
comment on table workflow_run_attribute           is 'Attributes for workflow runs, created by the attribute annotator';
comment on table workflow_run_input_files         is 'Tracks which files have been used as input for workflow runs (1.0.X, created by SeqWare)';
comment on table workflow_run_param               is 'Records parameters that a workflow was run with (created by SeqWare)';
